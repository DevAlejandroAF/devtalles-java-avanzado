package com.devtalles.proyecto.observer;

import io.reactivex.rxjava3.annotations.NonNull;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;

public class ObserverExample01 {
    public static void main(String[] args) {
        Observable<String> courseStream = Observable
                .fromIterable(
                        Arrays.asList("HTML", "CSS", null, "C").stream().filter(Objects::nonNull).collect(Collectors.toSet())
                );

        Observer<String> observer = new Observer<>() {
            private Disposable disposable;
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                this.disposable = d;
                System.out.println("Estoy suscripto al curso!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                if(s.equalsIgnoreCase("C")){
                    disposable.dispose();
                }else{
                    System.out.println("Recibí: " + s);
                }

            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Fin del Stream");
            }
        };

        Observer<String> observer2 = new Observer<>() {
            @Override
            public void onSubscribe(@NonNull Disposable d) {
                System.out.println("Estoy suscripto al curso soy observer2!!!");
            }

            @Override
            public void onNext(@NonNull String s) {
                System.out.println("Soy observer2 recibí: " + s);
            }

            @Override
            public void onError(@NonNull Throwable e) {
                System.out.println("Error: " + e.getMessage());
            }

            @Override
            public void onComplete() {
                System.out.println("Fin del Stream observer2");
            }
        };

        courseStream.subscribe(observer);
        courseStream.subscribe(observer2);
    }
}
