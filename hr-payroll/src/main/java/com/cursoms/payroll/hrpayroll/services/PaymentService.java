package com.cursoms.payroll.hrpayroll.services;

import com.cursoms.payroll.hrpayroll.entities.Payment;
import com.cursoms.payroll.hrpayroll.entities.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {
    
    @Autowired
    private RestTemplate restTemplate;

    @Value("${host}")
    private String host;

    public Payment getPayment(Long id, Integer days){
        
        String url = host+"/workers/"+id;
        System.out.println(url);
        Worker worker = restTemplate.getForObject(url, Worker.class);
        return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

}
