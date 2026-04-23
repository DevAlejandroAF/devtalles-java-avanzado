package com.devtalles.proyecto.example01;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Optional<String> name = Optional.of("Gabriel");

        if(name.isPresent()){
            System.out.println("El nombre esta presente");
        }

        String value = "Daniel";

        Optional<String> nick = Optional.ofNullable(value);
        Optional<String> empty = Optional.empty();

        if(empty.isPresent()){
            System.out.println("El nombre esta presente");
        }else{
            System.out.println("Vacio");
        }

        Optional<String> greeding = Optional.of("Hola mundo");

        greeding.ifPresent( message -> System.out.println("Soy Gabriel: " + message));

        Scanner scanner = new Scanner(System.in);


    }
}