package com.devtalles.proyecto.schedulers;

import io.reactivex.rxjava3.core.Observable;
import java.util.Arrays;
import java.util.List;

public class SchedulerExample {
    public static void main(String[] args) throws InterruptedException {
        List<String> students = Arrays.asList("Ana", "Luis", "Carlos", "Sofía");
        List<String> teachers = Arrays.asList("Prof. Gómez", "Prof. Díaz", "Prof. Luis");

        String searchQuery = "Luis";

        Observable<String> studentSearch = Observable.fromIterable(students)
                .filter(name -> name.contains(searchQuery))
                .doOnNext(s -> System.out.println("🎓 Estudiante encontrado: " + s +
                        " en hilo: " + Thread.currentThread().getName()));

        Observable<String> teacherSearch = Observable.fromIterable(teachers)
                .filter(name -> name.contains(searchQuery))
                .doOnNext(t -> System.out.println("👨‍🏫 Profesor encontrado: " + t +
                        " en hilo: " + Thread.currentThread().getName()));

        Observable.merge(studentSearch, teacherSearch)
                .subscribe(result -> System.out.println("📢 Resultado final: " + result +
                        " en hilo: " + Thread.currentThread().getName()));
    }
}
