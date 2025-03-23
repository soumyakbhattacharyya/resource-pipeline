package org.resource.pipeline.system.valueobject;

import java.util.Objects;

// Base class for value object
public abstract class BaseId<T> {
    private final T value;

    protected BaseId(T value) {this.value = value;}
    public T getValue() {return this.value;}

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        BaseId<?> baseId = (BaseId<?>) o;
        return Objects.equals(getValue(), baseId.getValue());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getValue());
    }
}

