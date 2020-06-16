package com.okunevtuturkin.patterns.pojo.orders;

import com.okunevtuturkin.patterns.pojo.products.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Order {

    private final List<Entry> products;

    private Order(List<Entry> products) {
        this.products = Collections.unmodifiableList(products);
    }

    public List<Entry> getProducts() {
        return products;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static class Builder {
        private final List<Entry> products;

        private Builder() {
            products = new ArrayList<>();
        }

        public Builder addProduct(Product product) {
            Objects.requireNonNull(product);
            products.add(new Entry(product));
            return this;
        }

        public Order build() {
            return new Order(products);
        }
    }

    public static class Entry {
        private final Product product;
        private boolean isCancelled;

        public Entry(Product product) {
            this.product = product;
            isCancelled = false;
        }

        public Product getProduct() {
            return product;
        }

        public boolean isCancelled() {
            return isCancelled;
        }

        public void cancel() {
            isCancelled = true;
        }
    }

}
