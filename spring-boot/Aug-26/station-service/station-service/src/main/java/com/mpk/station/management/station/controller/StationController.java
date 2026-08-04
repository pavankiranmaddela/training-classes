package com.mpk.station.management.station.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stations")
public class StationController {

    @PostMapping
    public String create(@RequestBody String name) {
        return name;
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
