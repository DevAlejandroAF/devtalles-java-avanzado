package com.devtalles.proyecto;

public class Main {
    public static void main(String[] args) {

        Operation operation = new Operation() {
            @Override
            public int operate(int a, int b) {
                return a + b;
            }
        };

        System.out.println(operation.operate(5, 5));


        Operation multiply = (a, b) -> {
            if(b>0) return a * b;
            return -1;
        };

        System.out.println(multiply.operate(4, 5));

        Operation subtraction = (a, b) -> a - b;

        System.out.println(subtraction.operate(4, 5));

    }
}

@FunctionalInterface
interface Operation{
    int operate(int a, int b);

    default String show(){
        return "Soy una operación";
    }
    default String show2(){
        return "Soy una operación";
    }

    static Operation subtraction(){
        return (a, b) -> a - b ;
    }
}








