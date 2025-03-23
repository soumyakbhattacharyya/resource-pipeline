package org.resource.pipeline.system.valueobject;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Objects;

public final class BaseDateTime {

    private final ZonedDateTime value;

    // Default zone (can be configured or injected)
    private static final ZoneId DEFAULT_ZONE = ZoneId.of("Asia/Kolkata");

    private BaseDateTime(ZonedDateTime value) {
        this.value = value.withZoneSameInstant(DEFAULT_ZONE);
    }

    public static BaseDateTime now() {
        return new BaseDateTime(ZonedDateTime.now(DEFAULT_ZONE));
    }

    public static BaseDateTime of(ZonedDateTime input) {
        return new BaseDateTime(input);
    }

    public static BaseDateTime fromEpochMillis(long epochMillis) {
        return new BaseDateTime(ZonedDateTime.ofInstant(
                java.time.Instant.ofEpochMilli(epochMillis),
                DEFAULT_ZONE
        ));
    }

    public ZonedDateTime get() {
        return value;
    }

    public String toIsoString() {
        return value.toString();
    }

    public boolean isBefore(BaseDateTime other) {
        return this.value.isBefore(other.value);
    }

    public boolean isAfter(BaseDateTime other) {
        return this.value.isAfter(other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseDateTime)) return false;
        BaseDateTime that = (BaseDateTime) o;
        return value.isEqual(that.value); // Logical equality
    }

    @Override
    public int hashCode() {
        return Objects.hash(value.toInstant()); // Ensure consistent hash
    }

    @Override
    public String toString() {
        return toIsoString();
    }
}
