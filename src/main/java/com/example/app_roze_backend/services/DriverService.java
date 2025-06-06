package com.example.app_roze_backend.services;

import com.example.app_roze_backend.models.Driver;
import com.example.app_roze_backend.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService {

    @Autowired
    private DriverRepository repository;

    //get post, put, delete
    public List<Driver> getAllDrivers() throws Exception{
        try {
            return repository.findAll();
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Driver getDriverById(UUID id) throws Exception{
        try {
           Optional<Driver> searchDriver = repository.findById(id);
           if(searchDriver.isPresent()){
               return searchDriver.get();
           } else {
               throw new Exception("Conductor no encontrado");
           }
        } catch(Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Driver createDriver(Driver dataDriver) throws Exception{
        try {
            return repository.save(dataDriver);
        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

    public Driver updateDriver(UUID id, Driver updateDriver) throws Exception{
        try {
            Optional<Driver> searchDriver = repository.findById(id);
            if(searchDriver.isPresent()){
                searchDriver.get().setEmail(updateDriver.getEmail());
                searchDriver.get().setName(updateDriver.getName());
                return searchDriver.get();
            } else {
                throw new Exception("El usuario no ha sido encontrado");
            }
        } catch(Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean deleteDriver(UUID id) throws Exception{
        try {
            Optional<Driver> searchDriver = repository.findById(id);
            if(searchDriver.isPresent()){
                repository.deleteById(id);
                return true;
            } else {
                throw new Exception("Usuario no encontrado");
            }
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
