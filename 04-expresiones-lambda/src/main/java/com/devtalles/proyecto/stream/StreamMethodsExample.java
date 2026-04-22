package com.devtalles.proyecto.stream;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamMethodsExample {
    public static void main(String[] args) {

        List<String> names = List.of("Ana", "Luis", "Marta", "Juan", "Ana", "Fernando");
        List<String> longNames  = names.stream()
                .filter(name -> name.length() > 3)  // Filtra nombres de más de 3 letras
                .toList();

        System.out.println(longNames);


        List<Integer> lengthNames = names.stream()
                .map(String::length)  // Convierte cada nombre a su longitud
                .collect(Collectors.toList());



        List<List<Integer>> list = List.of(List.of(1, 2), List.of(3, 4));
        List<Integer> flatNames = list.stream()
                .flatMap(List::stream)  // "Aplana" las listas anidadas
                .collect(Collectors.toList());

        System.out.println(flatNames);

        List<Integer> numbers = List.of(3, 1, 3, 5, 2);
        List<Integer> uniqueOrdered = numbers.stream()
                .distinct()  // Elimina duplicados
                .sorted()    // Ordena
                .toList();

        System.out.println(uniqueOrdered);


        Set<String> setNames = names.stream()
                .filter(n -> n.length() > 2)
                .collect(Collectors.toSet());  // Convierte a Set

        System.out.println(setNames);


        long count = names.stream()
                .filter(n -> n.contains("a"))
                .count();  // Cuenta elementos
        System.out.println(count);


        int sum = numbers.stream()
                .reduce(0, (result, number) -> result + number);


        System.out.println(sum);


        names.stream()
                .map(String::toUpperCase)
                .forEach(System.out::println);  // Efecto secundario





    }
}
