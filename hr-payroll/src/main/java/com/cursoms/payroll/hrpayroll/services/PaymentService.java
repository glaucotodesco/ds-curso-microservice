package com.cursoms.payroll.hrpayroll.services;

import com.cursoms.payroll.hrpayroll.entities.Payment;
import com.cursoms.payroll.hrpayroll.entities.Worker;
import com.cursoms.payroll.hrpayroll.feignclients.WorkerFeignClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class PaymentService {
    
    @Autowired
    private WorkerFeignClient workerFeignClient;

    public Payment getPayment(Long id, Integer days){
       Worker worker = workerFeignClient.getWorkerById(id).getBody();
       return new Payment(worker.getName(),worker.getDailyIncome(),days);
    }

}
