package com.okunevtuturkin.patterns.pojo.money;

import java.util.Objects;

public class Rubble {

    private final double value;

    public Rubble(double value) {
        this.value = value;
    }

    public String getCurrency() {
        return "Rub";
    }

    public Rubble plus(Rubble rubble) {
        Objects.requireNonNull(rubble);
        return new Rubble(this.value + rubble.value);
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", value, getCurrency());
    }

}
