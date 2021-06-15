package com.iotproject.iotservice.repository;

import com.iotproject.iotservice.entity.Reading;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;


public interface ReadingRepository extends JpaRepository<Reading, Long> {
    Reading findByStationName(String stationName);
    List<Reading> findAllByStationName(String stationName);
    List<Reading> findAllByStationId(long stationName);
}
