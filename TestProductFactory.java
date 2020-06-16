package com.okunevtuturkin.patterns.pojo.products;

import com.okunevtuturkin.patterns.pojo.TestFactory;
import com.okunevtuturkin.patterns.pojo.money.Rubble;
import com.okunevtuturkin.patterns.pojo.weights.Gramme;

import java.util.List;

public class TestProductFactory implements TestFactory<Product> {
    @Override
    public List<Product> getData() {
        return List.of(
                new Product("Milk", new Gramme(450), new Rubble(200)),
                new Product("Cheese", new Gramme(300), new Rubble(150)),
                new Product("Bread", new Gramme(100), new Rubble(24)),
                new Product("Apple", new Gramme(50), new Rubble(20)),
                new Product("Tea", new Gramme(60), new Rubble(100))
        );
    }
}
