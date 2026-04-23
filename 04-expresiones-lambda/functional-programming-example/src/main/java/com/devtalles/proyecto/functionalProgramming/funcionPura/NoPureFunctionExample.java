package com.devtalles.proyecto.functionalProgramming.funcionPura;

public class NoPureFunctionExample {

    static int contador = 0; // estado compartido (efecto colateral)

    public static int incrementCounter(int valor) {
        contador += valor; // modifica estado global
        return contador;
    }

    public static void main(String[] args) {
        System.out.println("Resultado 1: " + incrementCounter(5)); // Resultado 1: 5
        System.out.println("Resultado 2: " + incrementCounter(5)); // Resultado 2: 10
    }
}

