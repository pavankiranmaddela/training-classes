package com.mpk.station.management.station.controller;

import com.mpk.station.management.station.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {
    public StationService stationService;

    @Autowired
    public StationController(StationService stationService) {
        this.stationService = stationService;
    }

    @PostMapping
    public String create(@RequestBody String name) {
        return stationService.createStation(name);
    }
    //get - GET
    @GetMapping("/{name}")
    public String get(@PathVariable String name) {
        return name;
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
