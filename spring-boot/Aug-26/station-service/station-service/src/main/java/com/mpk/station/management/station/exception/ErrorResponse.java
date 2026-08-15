package com.mpk.station.management.station.exception;

import java.time.Instant;
import java.util.Map;

/**
 * Standard structured error payload returned to clients by
 * {@link GlobalExceptionHandler}.
 *
 * @param timestamp   the instant the error occurred
 * @param status      the HTTP status code
 * @param error       the HTTP status reason phrase (e.g. "Not Found")
 * @param message     a human-readable description of the error
 * @param path        the request path that triggered the error
 * @param fieldErrors validation field errors, keyed by field name (may be {@code null})
 */
public record ErrorResponse(
        Instant timestamp,
        int status,
        String error,
        String message,
        String path,
        Map<String, String> fieldErrors
) {

    public static ErrorResponse of(int status, String error, String message, String path) {
        return new ErrorResponse(Instant.now(), status, error, message, path, null);
    }

    public static ErrorResponse of(int status, String error, String message, String path, Map<String, String> fieldErrors) {
        return new ErrorResponse(Instant.now(), status, error, message, path, fieldErrors);
    }
}