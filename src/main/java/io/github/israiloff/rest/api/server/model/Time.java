package io.github.israiloff.rest.api.server.model;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Processing time details.
 *
 * @param startedAt The time when the processing started.
 * @param endedAt   The time when the processing ended.
 */
public record Time(LocalDateTime startedAt, LocalDateTime endedAt) implements Serializable {
}
