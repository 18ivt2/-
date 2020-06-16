package com.okunevtuturkin.patterns;

import com.okunevtuturkin.patterns.pojo.orders.OrderSerializer;
import com.okunevtuturkin.patterns.pojo.products.ProductSerializer;
import com.okunevtuturkin.patterns.pojo.products.ProductsFlyweight;
import com.okunevtuturkin.patterns.pojo.products.TestProductFactory;

public class Context {

    private static volatile Context instance;

    private final ProductsFlyweight products;
    private final OrderSerializer orderSerializer;
    private final ProductSerializer productSerializer;

    public static OrderSerializer getOrderSerializer() {
        return getInstance().orderSerializer;
    }

    public static ProductSerializer getProductSerializer() {
        return getInstance().productSerializer;
    }

    public static ProductsFlyweight getProducts() {
        return getInstance().products;
    }

    private Context() {
        products = new ProductsFlyweight(new TestProductFactory().getData());
        productSerializer = new ProductSerializer();
        orderSerializer = new OrderSerializer(productSerializer);
    }

    public static Context getInstance() {
        Context localInstance = instance;
        if (instance == null) {
            synchronized (Context.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new Context();
                }
            }
        }
        return localInstance;
    }
}
