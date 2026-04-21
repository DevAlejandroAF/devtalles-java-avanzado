package com.devtalles.proyecto.object.queue;

public class Main{
    public static void main(String[] args) {
        Queue<Integer> numbers = new Queue<>();

        numbers.enqueue(10);
        numbers.enqueue(20);
        numbers.enqueue(30);

        numbers.print();

        System.out.println("Ver primero de la fila " + numbers.peek());
        System.out.println("Eliminar el primero de la fila " + numbers.dequeue());

        numbers.print();

        Queue<String> names = new Queue<>();

        names.enqueue("Fernando");
        names.enqueue("Maria");

        names.print();
    }
}
