package com.example.app_roze_backend.services;


import com.example.app_roze_backend.models.Traveler;
import com.example.app_roze_backend.repository.TravelerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TravelerService {

    @Autowired
    private TravelerRepository repository;

    public List<Traveler> getAllTraveler() throws Exception{
        try {
            return repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Traveler getTravelerById(UUID id) throws Exception{
        try {
            Optional<Traveler> searchedTraveler = repository.findById(id);
            if(searchedTraveler.isPresent()){
                return searchedTraveler.get();
            } else {
                throw new Exception("Viajero no encontrado");
            }
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Traveler createTraveler(Traveler dataTraveler) throws Exception{
        try {
            return repository.save(dataTraveler);
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public Traveler updatedTraveler(UUID id, Traveler updateTraveler) throws Exception{
        try {
            Optional<Traveler> searchedTraveler = repository.findById(id);
            if(searchedTraveler.isPresent()){
                searchedTraveler.get().setEmail(updateTraveler.getEmail());
                searchedTraveler.get().setName(updateTraveler.getName());
                return searchedTraveler.get();
            } else {
                throw new Exception("Viajero no encontrado");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteTravelerById(UUID id) throws Exception {
        try {
            Optional<Traveler> searchedTraveler = repository.findById(id);
            if(searchedTraveler.isPresent()){
                repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Viajero no encontrado");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
