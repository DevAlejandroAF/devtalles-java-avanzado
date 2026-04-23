package com.devtalles.proyecto.example03;

import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //map
        Optional<String> name = Optional.of("     gaBriel    ");
        String nameUpperCase = name
                        .map(String::trim)
                        .map( String::toLowerCase)
                        .orElse("Sin nombre");

        System.out.println("Username: " + nameUpperCase);

        //flatmap
        Optional<Optional<String>> optionalOfOptional = Optional.of(Optional.empty());

        Optional<String> resultMap = optionalOfOptional.map(op-> op.orElse("default"));

        Optional<String> resultFlatMap = optionalOfOptional.flatMap(op-> op);

        //System.out.println(resultMap);
        System.out.println(resultFlatMap);

        //filter

        Optional<String> dni = Optional.of("1234567");

        Optional<String> result = dni.filter( d -> d.startsWith("1"));

        System.out.println("DNI: " + result.orElse("No válido"));


        Optional<String> email = Optional.ofNullable("    gabrieldevtalles.com     ");


        email.map(String::trim)
                .filter(e-> e.contains("@"))
                .ifPresent( message -> System.out.println("Enviando correo a: " + message));



















    }
}
