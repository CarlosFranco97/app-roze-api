package com.example.app_roze_backend.controllers;

import com.example.app_roze_backend.models.Traveler;
import com.example.app_roze_backend.services.TravelerService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/viajero")
public class TravelerController {

    @Autowired
    private TravelerService service;

    @GetMapping("")
    public ResponseEntity<?> getAllTraveler(){
        try {
            return new ResponseEntity<>(this.service.getAllTraveler(), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTravelerId(@PathVariable  UUID id){
        try {
            return new ResponseEntity<>(this.service.getTravelerById(id), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> createTraveler(@RequestBody Traveler dataTraveler){
        try {
            return new ResponseEntity<>(this.service.createTraveler(dataTraveler), HttpStatus.CREATED);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatedTraveler(@PathVariable  UUID id, @RequestBody Traveler updateTraveler){
        try {
            return new ResponseEntity<>(this.service.updatedTraveler(id, updateTraveler), HttpStatus.OK);
        } catch(Exception error){
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTravelerById(@PathVariable UUID id) {
        try {
            return new ResponseEntity<>(this.service.deleteTravelerById(id), HttpStatus.OK);
        } catch (Exception error) {
            return new ResponseEntity<>(error.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
