package com.cursoms.worker.hrworker.resources;

import java.util.List;

import com.cursoms.worker.hrworker.entities.Worker;
import com.cursoms.worker.hrworker.repositories.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RefreshScope
@RestController
@RequestMapping("/api/v1/workers")
public class WorkerResource {
    
    @Autowired
    private WorkerRepository repository;

    @Value("${test.config}")
    private String test;


    @GetMapping
    public ResponseEntity<List<Worker>> getAll(){
        List<Worker> workers = repository.findAll();

        workers.forEach( w -> System.out.println(w.getName()));


        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id){
        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }

    @GetMapping("/configs")
    public ResponseEntity<Void> test(){
        
        log.info(test);
        
        return ResponseEntity.noContent().build();
    }
    
}
