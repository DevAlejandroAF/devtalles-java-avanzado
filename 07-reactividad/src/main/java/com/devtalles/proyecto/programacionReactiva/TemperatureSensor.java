package com.devtalles.proyecto.programacionReactiva;

import io.reactivex.rxjava3.core.Observable;

import java.util.concurrent.TimeUnit;

public class TemperatureSensor {
    public static void main(String[] args) throws InterruptedException {
        Observable<Long> interval = Observable.interval(1, TimeUnit.SECONDS);


        Observable<Double> temperatureStream = interval.map(
                _ -> {
                    double temp = 20 + Math.random() * 15;
                    System.out.println("Temperatura actual: " + temp);
                    return temp;
                }
        );

        temperatureStream
                .filter(temp -> temp > 30)
                .subscribe(
                item -> System.out.println("Alerta: Temperatura alta: " + item),
                throwable -> System.out.println(throwable.getMessage())
        );

        Thread.sleep(10000);
    }
}
