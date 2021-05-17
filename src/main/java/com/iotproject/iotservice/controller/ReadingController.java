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
    public Reading addReading(@RequestBody Reading reading){
        return service.saveReading(reading);
    }

    @PostMapping("/addReadings")
    public List<Reading> addReadings(@RequestBody List<Reading> readings){
        return service.saveReadings(readings);
    }

    @GetMapping("/readings/")
    public List<Reading> getReadings(){
        return service.getReadings();
    }

    @GetMapping("/readings/{id}")
    public Reading getReadingsByID(@PathVariable int id){
        return service.getReadingByID(id);
    }

    @GetMapping("/readings/getLatestReading")
    public Reading getLatestReadingByID(@RequestParam String stationName){
        return service.getLatestReadingByName(stationName);
    }

    @GetMapping("/readings/name/location")
    public Reading getReadingsByName(@RequestParam String stationName){
        return service.getReadingByName(stationName);
    }

    @GetMapping("readings/name/locations")
    public List<Reading> getAllReadingsByName(@RequestParam String stationName){
        return service.getAllReadingByName(stationName);
    }

    @PutMapping("/update")
    public Reading updateReading(@RequestBody Reading reading){
        return service.updateReading(reading);
    }

    @DeleteMapping("delete/{id}")
    public String deleteReading(@PathVariable long id){
        return service.deleteReading(id);
    }
}
