package com.cursoms.payroll.hrpayroll.resources;

import com.cursoms.payroll.hrpayroll.entities.Payment;
import com.cursoms.payroll.hrpayroll.services.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * PaymentResource
 */
@RestController
@RequestMapping("/api/v1/payments")
public class PaymentResource {

    @Autowired
    private PaymentService service;

    @HystrixCommand(fallbackMethod = "getPaymentAlternative")
    @GetMapping("{id}/days/{days}")
    public ResponseEntity<Payment> getPayment(@PathVariable Long id, @PathVariable Integer days){
        Payment pay = service.getPayment(id, days);
        return ResponseEntity.ok(pay);
    }


    
    public ResponseEntity<Payment> getPaymentAlternative(Long id, Integer days){
        Payment pay = new Payment("Brann", 400.0, days);
        return ResponseEntity.ok(pay);
    }
    
}