package com.devtalles.proyecto.functionalProgramming.funcionPura;

import java.util.function.Function;
import java.util.function.IntFunction;

public class PureFunction {

    public static int multiplyByTwo(int number) {
        return number * 2;
    }

    public static void main(String[] args) {
        int result = multiplyByTwo(4);
        System.out.println("El resultado es: " + result); // El resultado es: 8

        PureFunction pureFunction = new PureFunction();
        pureFunction.functionalProgramming();
    }

    public void functionalProgramming(){
        Function<Integer, Integer> multiply = ( num ) -> num * 2;

        Integer result = multiply.apply(4);

        System.out.println(result);
    }
}

