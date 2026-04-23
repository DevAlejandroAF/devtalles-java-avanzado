package com.devtalles.proyecto.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExampleStream {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(1,2,3,4,5,6,7,8);
        Stream<Integer> streamNumbers = numbers.stream();
        //streamNumbers.forEach(System.out::println);

        Stream<String> stream = Stream.of("A", "B", "C");
        //stream.forEach(System.out::println);

        String[] array = {"X", "Y", "Z"};
        Stream<String> stream2 = Arrays.stream(array);
        //stream2.forEach(System.out::println);

        Stream<String> holaStream = Stream.generate(()-> "Hola Mundo!!!").limit(3);
        //holaStream.forEach(System.out::println);


        List<String> names = List.of("Ana", "Luis", "Marta", "Juan");

        names.stream()
                .filter(name -> name.length()>3)
                .map(name -> name.toUpperCase())
                .forEach(System.out::println);


        Stream<String> stream1 = Stream.of("Ana", "Luis", "Marta", "Juan");

        //stream1.forEach(System.out::println);

        List<String> strings = stream1.toList();
        System.out.println(strings);






    }
}
