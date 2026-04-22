package com.devtalles.proyecto.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ExamplesCollections {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Juan", "Ana", "Pedro");

        names.forEach(System.out::println);

        Consumer<String> name = (n) -> System.out.println(n);
        names.forEach(name);

        List<Integer> numbers = new ArrayList<>(List.of(1,2,3,4,5,6));

        numbers.removeIf(n -> n % 2 ==0);
        System.out.println(numbers);

        List<String> words = new ArrayList<>(List.of("Java", "Stream", "Lambda"));

        words.replaceAll(String::toUpperCase);

        System.out.println(words);

     }
}
