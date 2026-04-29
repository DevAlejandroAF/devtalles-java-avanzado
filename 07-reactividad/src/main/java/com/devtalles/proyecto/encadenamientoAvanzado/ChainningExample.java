package com.devtalles.proyecto.encadenamientoAvanzado;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

public class ChainningExample {
    public static void main(String[] args) {
        Observable<Student> studentObservable = Observable.just(
                new Student("Mario", 23),
                new Student("Juan", 33),
                new Student("Estela", 43)
        );

//        studentObservable
//                .filter(student -> student.getAge()>21)
//                .map(student -> student.getName().toUpperCase())
//                .subscribe(System.out::println);

        studentObservable
                .filter(student -> student.getAge()>21)
                .flatMap(student -> getSubjectsPerStudent(student.getName()))
                .subscribe(
                        s -> System.out.println("Materia: " + s),
                        error -> System.out.println(error.getMessage()),
                        () -> System.out.println("Fin")
                );


    }

    public static Observable<String> getSubjectsPerStudent(String name){
        if(name.equalsIgnoreCase("Juan")){
            return Observable.just("Programación 3", "Lenguaje");
        }
        return Observable.empty();
    }












}
