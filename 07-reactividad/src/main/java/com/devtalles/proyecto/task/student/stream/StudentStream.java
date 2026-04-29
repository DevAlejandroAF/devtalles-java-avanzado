// Archivo: src/main/java/com/devtalles/proyecto/task/student/stream/StudentStream.java
package com.devtalles.proyecto.task.student.stream;

import com.devtalles.proyecto.task.student.model.Student;
import io.reactivex.rxjava3.subjects.PublishSubject; // Importamos PublishSubject
import io.reactivex.rxjava3.subjects.Subject; // Importamos Subject

// Clase para gestionar el stream reactivo de estudiantes
public class StudentStream {

    // PublishSubject es un tipo de Subject que emite a los Observadores
    // los ítems que se emiten DESPUÉS de que el Observador se suscribe.
    // toSerialized() lo hace Thread-safe, importante si publicamos desde múltiples hilos.
    private final Subject<Student> subject = PublishSubject.<Student>create().toSerialized();


    // Método para publicar un nuevo estudiante en el stream
    public void publish(Student student) {
        subject.onNext(student);
    }

    // Método para obtener el stream al que los Observadores pueden suscribirse
    public Subject<Student> getStream() {
        return subject;
    }

    // Opcional: Método para completar el stream (emitir la señal onComplete)
    public void complete() {
        subject.onComplete();
    }

    // Opcional: Método para emitir un error en el stream
    public void error(Throwable throwable) {
        subject.onError(throwable);
    }
}
