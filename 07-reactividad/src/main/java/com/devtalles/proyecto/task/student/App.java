package com.devtalles.proyecto.task.student;

import com.devtalles.proyecto.task.student.model.Student; // Importamos la clase Student
import com.devtalles.proyecto.task.student.service.StudentService; // Importamos el servicio
import com.devtalles.proyecto.task.student.stream.StudentStream; // Importamos la clase del stream
import io.reactivex.rxjava3.core.Observer; // Importamos la interfaz Observer
import io.reactivex.rxjava3.disposables.Disposable; // Importamos Disposable
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;

import java.util.Scanner; // Importamos Scanner para leer la consola

// Clase principal de la aplicación
public class App {

    public static void main(String[] args) {
        System.out.println("🚀 Iniciando aplicación de gestión de estudiantes...");
        StudentService service = new StudentService();
        StudentStream stream = new StudentStream();

        Disposable streamSubscription = setupStreamSubscription(service, stream);

        handleConsoleInput(stream);

        stream.complete();

        if (!streamSubscription.isDisposed()) {
            streamSubscription.dispose();
            System.out.println("✅ Suscripción al stream descartada.");
        }

        System.out.println("🛑 Programa finalizado.");

    }

    private static Disposable setupStreamSubscription(StudentService service, StudentStream stream) {
        System.out.println("Configurando suscripción al stream de estudiantes...");

        Consumer<Student> onNextConsumer = student -> {
            System.out.println("⬇️ Recibido estudiante del stream: " + student.getName());
            service.addStudent(student);
            System.out.println("🟢 Estudiante agregado correctamente.");
            printCurrentStudents(service);
        };

        Consumer<Throwable> onErrorConsumer = e -> {
            System.out.println("⛔ Ocurrió un error en el stream: " + e.getMessage());
            e.printStackTrace();
        };

        Action onCompleteAction = () -> {
            System.out.println("✅ Stream de estudiantes completado.");
        };

        Disposable d = stream.getStream().subscribe(onNextConsumer, onErrorConsumer, onCompleteAction);
        System.out.println("🟢 Suscrito al stream de estudiantes.");

        return d;
    }

    // --- Método auxiliar: Imprime la lista actual de estudiantes ---
    private static void printCurrentStudents(StudentService service) {
        System.out.println("📋 Lista actual:");

        service.getAll().forEach(s -> System.out.println("🔸 " + s));
        System.out.println("--------------------");
    }

    // --- Método optimizado: Maneja la entrada por consola y publica en el stream ---
    private static void handleConsoleInput(StudentStream stream) {
        System.out.println("\\n--- Ingresá estudiantes ---");
        System.out.println("Escribí 'salir' para terminar.");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("👤 Ingresá el nombre del estudiante (o 'salir'): ");
            String name = scanner.nextLine();

            if ("salir".equalsIgnoreCase(name)) {
                break;
            }

            System.out.print("🎂 Ingresá la edad: ");
            int age;

            try {
                age = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {

                System.out.println("⚠️ Edad inválida. Por favor, ingresá un número.");
                continue;
            }
            Student newStudent = new Student(name, age);
            stream.publish(newStudent);
        }
        scanner.close();
        System.out.println("\\n--- Entrada por consola finalizada ---");
    }
}
