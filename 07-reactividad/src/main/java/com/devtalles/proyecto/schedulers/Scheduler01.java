package com.devtalles.proyecto.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Scheduler01 {
    public static void main(String[] args) throws InterruptedException {
        Observable.just("Hola")
                .subscribeOn(Schedulers.io())
                .doOnNext(string -> System.out.println(string + " Just: " + Thread.currentThread().getName()))
                .observeOn(Schedulers.computation())
                .map(s -> s + " mundo")
                .doOnNext(string -> System.out.println(" Map: " + Thread.currentThread().getName()))
                .subscribe(s -> System.out.println("🧵 Resultado: " + s + " "+ Thread.currentThread().getName()));

        Thread.sleep(1000);
    }
}
