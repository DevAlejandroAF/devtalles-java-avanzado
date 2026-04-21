package com.devtalles.proyecto.object.datastore;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        DataStore<User, String> userStore = new DataStore<>();

        try{
            System.out.println("Añadiendo usuarios...");
            userStore.add("123", new User("123", "Fernando"));
            userStore.add("1234", new User("1234", "María"));
            userStore.add("12345", new User("12345", "Ana"));
            //userStore.add(null, new User("12345", "Ana"));

            System.out.println("Encontrado: " + userStore.find("123"));
            System.out.println("Eliminado: " + userStore.remove("123"));

        }catch (NullPointerException e)
        {
            System.out.println(e.getMessage());
        }

        List<User> users = userStore.getAll();
        for (User user: users){
            System.out.println(user);
        }
    }
}
