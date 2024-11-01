package io.github.israiloff.rest.api.server.model;

import java.io.Serializable;

/**
 * Client model.
 *
 * @param data The data.
 * @param time Processing time details.
 */
public record ClientModel(String data, Time time) implements Serializable {
}
