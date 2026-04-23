package com.devtalles.proyecto.ternarios;

public class Main {
    public static void main(String[] args) {
        int age = 10;
        String message;

//        if (age >= 18) {
//            message = "Mayor de edad";
//        } else {
//            message = "Menor de edad";
//        }
//
//        System.out.println(message);

        //condición ? expresión_si_verdadero : expresión_si_falso.

        message = age >= 18 ? "Mayor de edad" : "Menor de edad";

        System.out.println(message);

        int score = 75;
        String level;

        if (score >= 90) {
            level = "Excelente";
        } else if (score >= 70) {
            level = "Bueno";
        } else {
            level = "Regular";
        }

        level = score >= 90 ? "Excelente" : score >= 70 ? "Bueno" : "Regular";


        //Ejercicio 3
        int accessLevel = 2;
        String accessMessage = "";

        if (accessLevel >= 1) {
            if (accessLevel >= 3) {
                accessMessage = "Acceso total.";
            } else {
                accessMessage = "Acceso parcial.";
            }
        }else{
            accessMessage = "Acceso denegado.";
        }

        accessMessage = accessLevel >= 1 ?
                (accessLevel >= 3 ? "Acceso total.": "Acceso parcial" )
                : "Acceso denegado";


















    }
}
