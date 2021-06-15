package com.iotproject.iotservice.controller;

import com.iotproject.iotservice.entity.Reading;
import com.iotproject.iotservice.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReadingController {

    @Autowired
    private ReadingService service;

    @PostMapping("/addReading")
    @CrossOrigin(origins = "http://localhost")
    public Reading addReading(@RequestBody Reading reading){
        return service.saveReading(reading);
    }

    @PostMapping("/addReadings")
    @CrossOrigin(origins = "http://localhost")
    public List<Reading> addReadings(@RequestBody List<Reading> readings){
        return service.saveReadings(readings);
    }

    @GetMapping("/readings/")
    @CrossOrigin(origins = "http://localhost")
    public List<Reading> getReadings(){
        return service.getReadings();
    }

    @GetMapping("/readings/{id}")
    @CrossOrigin(origins = "http://localhost")
    public Reading getReadingsByID(@PathVariable int id){
        return service.getReadingByID(id);
    }

    @GetMapping("/readings/getLatestReading")
    @CrossOrigin(origins = "http://localhost")
    public Reading getLatestReadingByID(@RequestParam String stationName){
        return service.getLatestReadingByName(stationName);
    }

    @GetMapping("/readings/getLatestReadingByID")
    @CrossOrigin(origins = "http://localhost")
    public Reading getLatestReadingByName(@RequestParam int stationID){
        return service.getLatestReadingByID(stationID);
    }

    @GetMapping("/readings/name/location")
    @CrossOrigin(origins = "http://localhost")
    public Reading getReadingsByName(@RequestParam String stationName){
        return service.getReadingByName(stationName);
    }

    @GetMapping("readings/name/locations")
    @CrossOrigin(origins = "http://localhost")
    public List<Reading> getAllReadingsByName(@RequestParam String stationName){
        return service.getAllReadingByName(stationName);
    }

    @PutMapping("/update")
    @CrossOrigin(origins = "http://localhost")
    public Reading updateReading(@RequestBody Reading reading){
        return service.updateReading(reading);
    }

    @DeleteMapping("delete/{id}")
    @CrossOrigin(origins = "http://localhost")
    public String deleteReading(@PathVariable long id){
        return service.deleteReading(id);
    }
}
