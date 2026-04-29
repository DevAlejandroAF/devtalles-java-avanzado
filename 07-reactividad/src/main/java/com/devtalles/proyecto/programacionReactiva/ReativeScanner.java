package com.devtalles.proyecto.programacionReactiva;

import io.reactivex.rxjava3.subjects.PublishSubject;

import java.util.Scanner;

public class ReativeScanner {
    public static void main(String[] args) {
        PublishSubject<String> inputStream = PublishSubject.create();

        inputStream.subscribe(
                item -> System.out.println("Recibido: " + item.toUpperCase()),
                error -> System.out.println(error.getMessage()),
                () -> System.out.println("Finalizado...")
        );

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingresá un texto o 'salir' para terminar la app");

        while (true){
            String input = scanner.nextLine();
            if(input.equalsIgnoreCase("salir")){
                inputStream.onComplete();
                break;
            }
            inputStream.onNext(input);
        }

        scanner.close();













    }
}
