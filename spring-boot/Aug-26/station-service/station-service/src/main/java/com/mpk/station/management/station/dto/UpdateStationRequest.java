package com.mpk.station.management.station.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * Request payload for {@code PUT /stations/{stationId}}.
 * <p>
 * This is a full-replace update: all fields are required, mirroring
 * {@link CreateStationRequest}. If the update changes the station's name,
 * address, or coordinates (a "material change") while the station is
 * {@code ACTIVE}, the station is reverted to {@code PENDING_APPROVAL} and
 * must be re-reviewed (Group 8 - Approval Workflow).
 */
public record UpdateStationRequest(

        @NotBlank(message = "name is required")
        @Size(max = 150, message = "name must be at most 150 characters")
        String name,

        @Size(max = 2000, message = "description must be at most 2000 characters")
        String description
) {
}

