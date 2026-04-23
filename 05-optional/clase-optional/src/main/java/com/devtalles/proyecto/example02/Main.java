package com.devtalles.proyecto.example02;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Ingrese su nombre");
//        String name = scanner.nextLine();
//
//        Optional<String> optionalName = Optional.empty();
//
//        if(name.isEmpty()){
//            name = optionalName.orElse("Invitado");
//        }
//        System.out.println(name);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su nombre");
        String nameInput = scanner.nextLine();

        Optional<String> optional = Optional.ofNullable(nameInput)
                .filter( name -> !name.isEmpty() );

        String name = optional.orElseThrow(() -> new IllegalStateException("Error..."));

        System.out.println(name);

        scanner.close();














    }
}
