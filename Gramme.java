package com.okunevtuturkin.patterns.pojo.weights;

import java.util.Objects;

public class Gramme {
    private final double value;

    public Gramme(double value) {
        this.value = value;
    }

    public String getDesignation() {
        return "Gramme";
    }

    public Gramme plus(Gramme gramme) {
        Objects.requireNonNull(gramme);
        return new Gramme(value + gramme.value);
    }

    @Override
    public String toString() {
        return String.format("%.3f %s", value, getDesignation());
    }

}
