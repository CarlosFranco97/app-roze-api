package com.example.app_roze_backend.controllers;

import com.example.app_roze_backend.models.Driver;
import com.example.app_roze_backend.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService service;

    @GetMapping("")
    public ResponseEntity<?> getAllDrivers(){
        try {
            return new ResponseEntity<>(service.getAllDrivers(), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getDriverById(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(this.service.getDriverById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createDriver(@RequestBody Driver dataDriver){
        try {
            return new ResponseEntity<>(this.service.createDriver(dataDriver), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateDriver(@PathVariable UUID id, @RequestBody Driver updatedDriver){
        try {
            return new ResponseEntity<>(this.service.updateDriver(id, updatedDriver), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteDriver(@PathVariable UUID id){
        try {
            return new ResponseEntity<>(this.service.deleteDriver(id), HttpStatus.OK);
        } catch (Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
