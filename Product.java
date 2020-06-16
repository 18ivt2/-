package com.okunevtuturkin.patterns.pojo.products;

import com.okunevtuturkin.patterns.pojo.money.Rubble;
import com.okunevtuturkin.patterns.pojo.weights.Gramme;

import java.util.HashMap;
import java.util.Objects;

public class Product {

    private final String name;
    private final Gramme weight;
    private final Rubble cost;
    private final HashMap<String, Object> additionalFields;

    public Product(String name, Gramme weight, Rubble cost, HashMap<String, Object> additionalFields) {
        Objects.requireNonNull(weight);
        Objects.requireNonNull(cost);
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        this.additionalFields = additionalFields;
    }

    public Product(String name, Gramme weight, Rubble cost) {
        Objects.requireNonNull(weight);
        Objects.requireNonNull(cost);
        this.name = name;
        this.weight = weight;
        this.cost = cost;
        additionalFields = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public Gramme getWeight() {
        return weight;
    }

    public Rubble getCost() {
        return cost;
    }

    public HashMap<String, Object> getAdditionalFields() {
        return additionalFields;
    }
}
