package com.devtalles.proyecto.object.queue;


import java.util.LinkedList;
import java.util.NoSuchElementException;

public class Queue<T> {
    private final LinkedList<T> elements = new LinkedList<>();

    public void enqueue(T element){
        elements.addLast(element);
        System.out.println("Elemento agregado " + element);
    }

    public T peek(){
        if(isEmpty()){
            throw new NoSuchElementException("La cola esta vacía");
        }
        return elements.getFirst();
    }

    public T dequeue(){
        if(isEmpty()){
            throw new NoSuchElementException("La cola esta vacía");
        }
        return elements.removeFirst();
    }

    public boolean isEmpty(){
        return elements.isEmpty();
    }

    public void print(){
        for (Object o: elements){
            System.out.println(o);
        }
    }
}
