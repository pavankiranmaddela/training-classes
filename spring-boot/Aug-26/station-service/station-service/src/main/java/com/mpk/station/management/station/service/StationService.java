package com.mpk.station.management.station.service;

import org.springframework.stereotype.Service;

@Service
public class StationService {
    public String createStation(String name) {
        return name + "service";
    }
}
