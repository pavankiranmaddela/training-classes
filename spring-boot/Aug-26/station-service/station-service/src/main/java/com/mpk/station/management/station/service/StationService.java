package com.mpk.station.management.station.service;

import com.mpk.station.management.station.model.Station;
import com.mpk.station.management.station.repository.StationRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class StationService {

    private final StationRepository stationRepository;

    public Station createStation(Station station) {
        Station saved = stationRepository.save(station);
        return saved;
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(String id) {
        Optional<Station> stationOptional = stationRepository.findById(UUID.fromString(id));
        return stationOptional.orElse(null);
    }
}
