package com.okunevtuturkin.patterns.pojo;

public interface Serializer<T> {

    String serialize(T object);

}
