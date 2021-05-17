package com.iotproject.iotservice.service;

import com.iotproject.iotservice.entity.Reading;
import com.iotproject.iotservice.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Service
public class ReadingService {

    @Autowired
    private ReadingRepository repository;

    public Reading saveReading(Reading reading){
        reading.setDateOfRegistration(LocalDateTime.now());
        return repository.save(reading);
    }

    public List<Reading> saveReadings(List<Reading> readings){
        return repository.saveAll(readings);
    }

    public List<Reading> getReadings(){
        return repository.findAll();
    }

    public Reading getReadingByID(long id){
        return repository.findById(id).orElse(null);
    }

    public Reading getLatestReadingByName(String stationName){
        LocalDateTime currentDate = LocalDateTime.now();
        List<Reading> listReading = repository.findAllByStationName(stationName);
        LocalDateTime actualDate = LocalDateTime.of(2021, 1, 1, 01,01);
        Reading actualReading = null;
        for(Reading reading : listReading){
            if((reading.getDateOfRegistration() != null) && (actualDate != null)) {
                if (reading.getDateOfRegistration().isAfter(actualDate)) {
                    actualDate = reading.getDateOfRegistration();
                    actualReading = reading;
                }
            }
        }
        return actualReading;
    }

    public Reading getReadingByName(String stationName){
        return repository.findByStationName(stationName);
    }

    public List<Reading> getAllReadingByName(String stationName){
        return repository.findAllByStationName(stationName);
    }

    public String deleteReading(long id){
        repository.deleteById(id);
        return "reading is removed" + id;
    }

    public Reading updateReading(Reading reading){
        Reading existingReading = repository.findById(reading.getIndicationId()).orElse(null);
        if (existingReading != null) {
            existingReading.setStationId(reading.getStationId());
            existingReading.setStationName(reading.getStationName());
            existingReading.setTemperature(reading.getTemperature());
            existingReading.setDisolvedOxigen(reading.getDisolvedOxigen());
            existingReading.setAcidity(reading.getAcidity());
            existingReading.setConductivity(reading.getConductivity());
            existingReading.setBod(reading.getBod());
            existingReading.setNitrogenTotal(reading.getNitrogenTotal());
            existingReading.setFecalColiform(reading.getFecalColiform());
            existingReading.setTotalColiform(reading.getTotalColiform());
            return repository.save(existingReading);
        } else {
            return null;
        }
    }
}
