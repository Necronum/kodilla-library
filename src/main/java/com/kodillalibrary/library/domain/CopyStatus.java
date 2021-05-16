package com.kodillalibrary.library.domain;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;

public enum CopyStatus {
    AVAILABLE, UNAVAILABLE, RENTED, LOST;

    public static Optional<CopyStatus> parseString(String value) {
        return Arrays.stream(values())
                .filter(status -> Objects.equals(status.name(), value))
                .findFirst();
    }
}
