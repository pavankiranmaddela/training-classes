package com.mpk.station.management.station.mapper;

import com.mpk.station.management.station.dto.CreateStationRequest;
import com.mpk.station.management.station.dto.StationResponse;
import com.mpk.station.management.station.dto.UpdateStationRequest;
import com.mpk.station.management.station.model.Station;

import java.util.UUID;

/**
 * Plain static-method mapper between {@code Station} / {@code StationAuditLog}
 * entities and their DTO representations.
 * <p>
 * Implemented as a simple utility class (rather than via MapStruct) to avoid
 * additional annotation-processor setup; it can be swapped for a generated
 * mapper later without changing call sites.
 */
public final class StationMapper {

    private StationMapper() {
    }

    /**
     * Builds a new {@link Station} entity from a create request. The new
     * owned by the given {@code ownerId} (taken from the authenticated caller,
     * never from the request body).
     */
    public static Station toEntity(CreateStationRequest request) {
        return Station.builder()
                .name(request.name())
                .description(request.description())
                .ownerId(request.ownerId())
                .build();
    }

    public static void applyUpdate(Station station, UpdateStationRequest request) {
        station.setName(request.name());
        station.setDescription(request.description());
    }

    public static StationResponse toResponse(Station station) {
        return new StationResponse(
                station.getId(),
                station.getName(),
                station.getDescription()
        );
    }
}
