package com.devtalles.proyecto.schedulers;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SchedulerList {
    public static void main(String[] args) throws InterruptedException {
            List<String> students = Arrays.asList("Ana", "Luis", "Carlos", "Sofía");
            List<String> teachers = Arrays.asList("Prof. Gómez", "Prof. Díaz", "Prof. Luis");

            String searchQuery = "Luis";

            Observable<String> studentSearch = Observable.fromIterable(students)
                    .filter(name -> name.contains(searchQuery))
                    .delay(500, TimeUnit.MILLISECONDS) // simula búsqueda lenta
                    .subscribeOn(Schedulers.io()) // hilo para tareas de IO
                    .doOnNext(s -> System.out.println("🎓 Estudiante encontrado: " + s +
                            " en " + Thread.currentThread().getName()));

            Observable<String> teacherSearch = Observable.fromIterable(teachers)
                    .filter(name -> name.contains(searchQuery))
                    .delay(700, TimeUnit.MILLISECONDS) // simula búsqueda un poco más lenta
                    .subscribeOn(Schedulers.computation()) // hilo para tareas computacionales
                    .doOnNext(t -> System.out.println("👨‍🏫 Profesor encontrado: " + t +
                            " en " + Thread.currentThread().getName()));

            Observable.merge(studentSearch, teacherSearch)
                    .observeOn(Schedulers.single()) // Mostrar resultados ordenados
                    .subscribe(result -> System.out.println("📢 Resultado final: " + result +
                            " en " + Thread.currentThread().getName()));

            // Esperamos a que terminen los procesos
            Thread.sleep(2000);
    }
}
