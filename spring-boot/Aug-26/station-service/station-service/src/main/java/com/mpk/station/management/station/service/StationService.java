package com.mpk.station.management.station.service;

import com.mpk.station.management.config.PaymentConfig;
import com.mpk.station.management.config.StationServiceConfig;
import com.mpk.station.management.station.dto.CreateStationRequest;
import com.mpk.station.management.station.dto.StationResponse;
import com.mpk.station.management.station.dto.UpdateStationRequest;
import com.mpk.station.management.station.exception.DuplicateStationException;
import com.mpk.station.management.station.exception.StationNotFoundException;
import com.mpk.station.management.station.mapper.StationMapper;
import com.mpk.station.management.station.model.Station;
import com.mpk.station.management.station.repository.StationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class StationService {

    private final StationRepository stationRepository;

    private final PaymentConfig paymentConfig;

    private final StationServiceConfig stationServiceConfig;

    public StationResponse createStation(CreateStationRequest request) {
        Station station = StationMapper.toEntity(request);
        Station exiting = stationRepository.findByName(station.getName());
        System.out.println("Payment config:" + paymentConfig);
        System.out.println("Station service config:" + stationServiceConfig);
        if (exiting != null) {
            throw new DuplicateStationException("Name cant be duplicate");
        }

        Station saved = stationRepository.save(station);
        return StationMapper.toResponse(saved);
    }

    public StationResponse updateStation(String stationId, UpdateStationRequest request) {
        Station exiting = stationRepository.findById(UUID.fromString(stationId)).orElse(null);

        if (exiting == null) {
            throw new StationNotFoundException("Station not found");
        }

        StationMapper.applyUpdate(exiting, request);

        Station saved = stationRepository.save(exiting);
        return StationMapper.toResponse(saved);
    }

    public List<Station> getAllStations() {
        return stationRepository.findAll();
    }

    public StationResponse getStationById(String id) {
        Optional<Station> stationOptional = stationRepository.findById(UUID.fromString(id));
        stationOptional.orElseThrow(() -> new StationNotFoundException("Station not found"));
        return StationMapper.toResponse(stationOptional.get());
    }

    public void deleteStation(String stationId) {
        Station existing = stationRepository.findById(UUID.fromString(stationId)).orElse(null);

        if (existing == null) {
            throw new StationNotFoundException("Station not found");
        }

        stationRepository.delete(existing);
    }
}
