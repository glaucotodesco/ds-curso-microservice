package com.cursoms.payroll.hrpayroll.feignclients;

import com.cursoms.payroll.hrpayroll.entities.Worker;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name="hr-worker", url ="localhost:8001", path ="/api/v1/workers")
public interface WorkerFeignClient {
    
    @GetMapping("{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id);
}
