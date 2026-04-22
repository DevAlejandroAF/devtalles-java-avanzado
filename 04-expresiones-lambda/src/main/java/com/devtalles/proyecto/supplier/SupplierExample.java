package com.devtalles.proyecto.supplier;

import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<Person> personFactory = () -> new Person();

        Person p1 = personFactory.get();
        p1.setName("Gabriel");
        System.out.println(p1.getName());
    }
}
