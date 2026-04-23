package com.devtalles.proyecto.function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, Integer> stringLength = String::length;
        int length = stringLength.apply("Programación");
        System.out.println("La longitud es: " + length);

        BiFunction<Integer, Integer, String> sumToString = (a, b) -> "Resultado: " + (a + b);

        String result = sumToString.apply(7, 5);

        System.out.println(result);
    }
}
