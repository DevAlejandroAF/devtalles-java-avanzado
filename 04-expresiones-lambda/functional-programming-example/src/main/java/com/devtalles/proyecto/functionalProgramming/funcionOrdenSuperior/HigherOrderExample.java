package com.devtalles.proyecto.functionalProgramming.funcionOrdenSuperior;

public class HigherOrderExample {

    public static void main(String[] args) {
        applyOperation(6, 2, (x, y) -> x * y);
    }

    static void applyOperation(int x, int y, Operation op) {
        int result = op.compute(x, y);
        System.out.println("El resultado de la operación es: " + result);
    }
}

@FunctionalInterface
interface Operation {
    int compute(int a, int b);
}


