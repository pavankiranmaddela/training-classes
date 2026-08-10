package com.mpk.station.management.station.controller;

import com.mpk.station.management.station.model.Station;
import com.mpk.station.management.station.repository.StationRepository;
import com.mpk.station.management.station.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RestController
@RequestMapping("/stations")
@RequiredArgsConstructor
public class StationController {

    public final StationService stationService;

    @PostMapping
    public Station create(@RequestBody Station station) {
        return stationService.createStation(station);
    }
    //get - GET
    @GetMapping
    public List<Station> getAll() {
        return stationService.getAllStations();
    }

    @GetMapping("/{stationId}")
    public Station get(@PathVariable String stationId) {
        return stationService.getStationById(stationId);
    }

    @PutMapping
    public String update(String name) {
        return name;
    }

    //delete - DELETE
    @DeleteMapping
    public String delete(String name) {
        return name;
    }
}
