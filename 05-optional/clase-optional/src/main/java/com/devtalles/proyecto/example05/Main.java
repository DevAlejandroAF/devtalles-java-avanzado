package com.devtalles.proyecto.example05;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {

        //ejemplo 4
        String maybeName = "Gabriel";

        Optional.ofNullable(maybeName)
                .ifPresentOrElse(
                        name -> System.out.println("Nombre encontrado: " + name.toUpperCase()),
                        () -> System.out.println("No se encontró ningún nombre")
                );

        //Ejemplo 5

        List<Optional<String>> optionals = List.of(
                Optional.of("Hola"),
                Optional.empty(),
                Optional.of("Chau")
        );


        optionals
                .stream().filter(Optional::isPresent)
                .map(Optional::get)
                .forEach(System.out::println);











    }
}
