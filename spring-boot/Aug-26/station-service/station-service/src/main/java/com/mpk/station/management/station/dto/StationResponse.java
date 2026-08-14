package com.mpk.station.management.station.dto;

import java.time.Instant;
import java.util.UUID;

/**
 * Full detail response for a single station, returned by
 * {@code GET /stations/{stationId}}, {@code POST /stations},
 * {@code PUT /stations/{stationId}}, and {@code POST /stations/{stationId}/duplicate}.
 */
public record StationResponse(
		UUID id,
		String name,
		String description
) {
}
