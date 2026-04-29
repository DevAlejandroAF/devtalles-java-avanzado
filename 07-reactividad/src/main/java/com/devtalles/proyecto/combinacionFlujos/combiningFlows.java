package com.devtalles.proyecto.combinacionFlujos;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

public class combiningFlows {
    public static void main(String[] args) throws InterruptedException {
//        Observable<String> students = Observable.just("Mario", "Ana", "Juana", "Fernando")
//                .delay(1, TimeUnit.SECONDS);
//
//
//        Observable<String> teachers = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juan", "Prof. Ricardo");
//
//        Observable.merge(students, teachers).subscribe(System.out::println);
//
//        Thread.sleep(2000);

//        Observable<String> students = Observable.just("Mario", "Ana", "Juana", "Fernando")
//                .delay(2, TimeUnit.SECONDS);
//
//
//        Observable<String> teachers = Observable.just("Prof. Carlos", "Prof. Ana", "Prof. Juan", "Prof. Ricardo");
//
//        Observable.concat(students, teachers).subscribe(System.out::println);
//
//        Thread.sleep(3000);


        Observable<String> students = Observable.just("Mario", "Ana", "Juana", "Fernando");
        Observable<Integer> ages = Observable.just(20, 30, 40, 50);

        Observable.zip(students, ages, ( name, age) -> new Student(name, age))
                .subscribe(student -> System.out.println(student));


















    }
}
