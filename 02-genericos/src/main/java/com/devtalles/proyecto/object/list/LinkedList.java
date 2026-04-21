package com.devtalles.proyecto.object.list;

public class LinkedList<T> {
    private Node<T> head;

    public void add(T data){
        Node<T> newNode = new Node<>(data);
        if(head==null){
            head = newNode;
        }else{
            Node<T> current = head;
            while (current.next!=null){
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void printList(){
        Node<T> current = head;
        while (current != null){
            System.out.println("Elemento: " + current.data);
            current = current.next;
        }
    }

}
