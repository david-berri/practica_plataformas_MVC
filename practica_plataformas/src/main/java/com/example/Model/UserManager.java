package com.example.Model;

import java.util.ArrayList;
import java.util.List;

public class UserManager {  //Gestiona los usuarios del sistema: agregar, validar y listar.

    private final List<User> users = new ArrayList<>(); //Lista de usuarios en memoria

    private boolean isIdDuplicate(long id) {        //Verifica si un ID ya está registrado.
        for (User u : users) {
            if (u.getId() == id) {
                return true;
            }
        }
        return false;
    }

     public User addUser(User user) {        // Agrega un usuario si el ID no existe.
        if (isIdDuplicate(user.getId())) {
            throw new IllegalArgumentException("El ID ya existe");
        }
        users.add(user);
        return user;
    }

    public List<User> getUsers() {      //Devuelve todos los usuarios registrados.
        return users;
    }

    public static class User {      //Representa un usuario con ID, nombre y carrera.
        
        public long id;
        public String name;
        public String carrera;

        public User() {     // Constructor vacío para JSON
        }

    
        public User(long id, String name, String carrera) {     //Constructor con todos los parámetros
            this.id = id;
            this.name = name;
            this.carrera = carrera;
        }

        public long getId() {   //Obtiene el ID del usuario
            return id;
        }

        public void setId(long id) {        //Establece el ID del usuario
            this.id = id;
        }

        public String getName() {       //Obtiene el nombre del usuario
            return name;
        }

        public void setName(String name) {      //Establece el nombre del usuario
            this.name = name;
        }

        public String getCarrera() {        //Obtiene la carrera del usuario
            return carrera;
        }

        public void setCarrera(String carrera) {        //Establece la carrera del usuario
            this.carrera = carrera;
        }
    }
}