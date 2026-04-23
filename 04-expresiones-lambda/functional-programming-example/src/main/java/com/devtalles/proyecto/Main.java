package com.devtalles.proyecto;

public class Main {
    public static void main(String[] args) {

        haceAlgoStatic();

        Main objeto = new Main();
        objeto.haceAlgo();

    }

    public static void haceAlgoStatic(){
        System.out.println("Hace algo static");
    }

    public void haceAlgo(){
        System.out.println("Hace algo");
    }
}