package com.devtalles.proyecto.student.stream;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.Subject;

public class StudentStream {

    private final Subject<Student> subject = PublishSubject.<Student>create().toSerialized();

    public void publish(Student student) {
        subject.onNext(student);
    }

    public Subject<Student> getStream() {
        return subject;
    }

    public void complete() {
        subject.onComplete();
    }

    public void error(Throwable throwable) {
        subject.onError(throwable);
    }
}

