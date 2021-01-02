package com.cursoms.worker.hrworker.resources;

import java.util.List;

import com.cursoms.worker.hrworker.entities.Worker;
import com.cursoms.worker.hrworker.repositories.WorkerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/workers")
public class WorkerResource {
    
    @Autowired
    private WorkerRepository repository;

    @GetMapping
    public List<Worker> getAll(){
        return repository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Worker> getWorkerById(@PathVariable Long id){
        Worker worker = repository.findById(id).get();
        return ResponseEntity.ok(worker);
    }

    
}
