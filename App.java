/*
Task:
Разработайте и реализуйте объектно-ориентированную модель , рассчитывающую общую стоимость и вес покупки в магазине.
Сама покупка собирается из различных товаров и продуктов, которые покупает отдельный человек. Известно, что все товары
и продукты обладают своей стоимостью и весом. Предусмотрите возможность добавления новых общих свойств
 */

package com.okunevtuturkin.patterns;

import com.okunevtuturkin.patterns.pojo.Serializer;
import com.okunevtuturkin.patterns.pojo.orders.Order;
import com.okunevtuturkin.patterns.pojo.products.Product;
import com.okunevtuturkin.patterns.pojo.products.ProductsFlyweight;

import java.util.stream.Collectors;

public class App implements Runnable {

    private final ProductsFlyweight products;
    private final Serializer<Order> orderSerializer;
    private final Serializer<Product> productSerializer;

    public static void main(String[] args) {
        new App().run();
    }

    private App() {
        products = Context.getProducts();
        productSerializer = Context.getProductSerializer();
        orderSerializer = Context.getOrderSerializer();
    }

    @Override
    public void run() {
        System.out.printf(
                "All products:\n%s",
                products.values().stream()
                        .map(productSerializer::serialize)
                        .collect(Collectors.joining("\n"))
        );

        final Order order = Order.newBuilder()
                .addProduct(products.get("Milk"))
                .addProduct(products.get("Cheese"))
                .addProduct(products.get("Tea"))
                .build();

        System.out.println("\n\n" + orderSerializer.serialize(order));

        order.getProducts().get(2).cancel();
        System.out.println(orderSerializer.serialize(order));
    }
}
