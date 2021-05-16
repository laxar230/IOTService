package com.iotproject.iotservice;

import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
public class Reading {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
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

    public Reading() {
    }

    public Reading(long stationId, String stationName, double temperature, double disolvedOxigen, double acidity, double conductivity, double bod, double nitrogenTotal, double fecalColiform, double totalColiform) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.temperature = temperature;
        this.disolvedOxigen = disolvedOxigen;
        this.acidity = acidity;
        this.conductivity = conductivity;
        this.bod = bod;
        this.nitrogenTotal = nitrogenTotal;
        this.fecalColiform = fecalColiform;
        this.totalColiform = totalColiform;
    }

}