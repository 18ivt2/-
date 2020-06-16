package com.okunevtuturkin.patterns.pojo.products;

import com.okunevtuturkin.patterns.pojo.Serializer;

import java.util.HashMap;

public class ProductSerializer implements Serializer<Product> {
    @Override
    public String serialize(Product product) {
        final StringBuilder builder = new StringBuilder();

        builder.append(product.getName())
                .append(", ")
                .append(product.getCost())
                .append(", ")
                .append(product.getWeight());

        final HashMap<String, Object> additionalFields = product.getAdditionalFields();
        if (!additionalFields.isEmpty()) {
            builder.append(", ");
            additionalFields.forEach((s, o) -> builder.append(s).append(": ").append(o));
        }

        return builder.toString();
    }
}
