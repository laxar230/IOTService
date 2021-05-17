package com.iotproject.iotservice.entity;

import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "general_register")
public class Reading {
    @Id
    @GeneratedValue
    private long indicationId;
    private long stationId;
    private String stationName;
    private double temperature;
    private double disolvedOxigen;
    private double acidity;
    private double conductivity;
    private double bod;
    private double nitrogenTotal;
    private double fecalColiform;
    private double totalColiform;
    private LocalDateTime dateOfRegistration;
}