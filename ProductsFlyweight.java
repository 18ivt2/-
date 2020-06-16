package com.okunevtuturkin.patterns.pojo.products;

import java.util.Hashtable;
import java.util.List;

public class ProductsFlyweight extends Hashtable<String, Product> {
    public ProductsFlyweight(List<Product> data) {
        data.forEach(this::put);
    }

    public Product put(Product product) {
        return super.put(product.getName(), product);
    }
}
