package com.mpk.station.management.station.service;

import com.mpk.station.management.station.dto.CreateStationRequest;
import com.mpk.station.management.station.dto.StationResponse;
import com.mpk.station.management.station.mapper.StationMapper;
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

    public StationResponse createStation(CreateStationRequest request) {
        Station station = StationMapper.toEntity(request);
        Station exiting = stationRepository.findByName(station.getName());

        if (exiting != null) {
            throw new RuntimeException("Name cant be duplicate");
        }

        Station saved = stationRepository.save(station);
        return StationMapper.toResponse(saved);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public Station getStationById(String id) {
        Optional<Station> stationOptional = stationRepository.findById(UUID.fromString(id));
        return stationOptional.orElse(null);
    }
}
