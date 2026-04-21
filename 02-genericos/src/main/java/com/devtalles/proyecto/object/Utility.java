package com.devtalles.proyecto.object;

public class Utility {
    public static <T> void printItem(T value) {
        System.out.println(value);
    }
    public static <T, K> void printItem(T value, K key){
        System.out.println(value + " " + key);
    }
}
