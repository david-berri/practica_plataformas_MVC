package com.example.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.UserManager;
import com.example.Model.UserManager.User;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller_act {


    private final UserManager userManager = new UserManager();      //Instancia del gestor de usuarios

    
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {   //Crea un nuevo usuario. 201 si se crea exitosamente, 409 si el ID ya existe
        try {
            User createdUser = userManager.addUser(user);
            System.out.println("Usuario creado: " + createdUser.getName());
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/users")       //Devuelve la lista de usuarios registrados
    public List<User> listUsers() {
        return userManager.getUsers();
    }
}