package com.devtalles.proyecto.functionalProgramming.inmutabilidad;

public class ImmutabilityExample {
    public static int[] addNumber(int[] original, int numberToAdd) {
        int[] newArray = new int[original.length + 1];
        for (int i = 0; i < original.length; i++) {
            newArray[i] = original[i];
        }
        newArray[original.length] = numberToAdd;
        return newArray;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 2, 3};
        int[] updatedNumbers = addNumber(numbers, 4);

        System.out.print("Array original: ");
        for (int n : numbers) {
            System.out.print(n + " ");
        }

        System.out.print("\nArray nuevo: ");
        for (int n : updatedNumbers) {
            System.out.print(n + " ");
        }
    }
}

