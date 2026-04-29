package com.devtalles.proyecto.student.controller;

import com.devtalles.proyecto.student.service.StudentService;
import com.devtalles.proyecto.student.stream.StudentStream;
import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.core.Observable;

public class StudentController {
    private final StudentStream stream;
    private final StudentService service;

    public StudentController(StudentStream stream, StudentService service) {
        this.stream = stream;
        this.service = service;
//        this.service.subscribeTo(
//
//                stream.getStream()
//                        .flatMap(service::verifyStudent)
//                        .flatMap(student -> service.validateName(student)
//                                .onErrorResumeNext(throwable -> {
//                                    System.out.println("Error: " + throwable.getMessage());
//                                    return Observable.empty();
//                                })
//
//                        )
//        );
        this.service.subscribeTo(

                stream.getStream()
                        .flatMap(service::verifyStudent)
                        .flatMap(service::validateName)
                        .onErrorReturn(e -> new Student("Estudiante inválido", 0)));
    }

    public boolean processInput(String name, String ageInput){
        try{
            int age = Integer.parseInt(ageInput);
            stream.publish(new Student(name, age));
            return true;
        }catch (NumberFormatException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public void finishInput(){
        stream.complete();
    }
}
