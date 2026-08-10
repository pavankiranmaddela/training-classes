package com.mpk.station.management.station.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

/**
 * Request payload for {@code POST /stations}.
 * <p>
 * The new station's owner is taken from the authenticated caller
 * ({@code X-User-Id}), not from this payload, so it cannot be spoofed.
 * The station is created in {@code DRAFT} status.
 */
public record CreateStationRequest(

		@NotBlank(message = "name is required")
		@Size(max = 150, message = "name must be at most 150 characters")
		String name,

		@Size(max = 2000, message = "description must be at most 2000 characters")
		String description,

		@NotNull(message = "latitude is required")
		@DecimalMin(value = "-90.0", message = "latitude must be >= -90")
		@DecimalMax(value = "90.0", message = "latitude must be <= 90")
		Double latitude,

		@NotNull(message = "longitude is required")
		@DecimalMin(value = "-180.0", message = "longitude must be >= -180")
		@DecimalMax(value = "180.0", message = "longitude must be <= 180")
		Double longitude,

		@Size(max = 30, message = "contactPhone must be at most 30 characters")
		String contactPhone,

		@Email(message = "contactEmail must be a valid email address")
		@Size(max = 150, message = "contactEmail must be at most 150 characters")
		String contactEmail
) {
}
