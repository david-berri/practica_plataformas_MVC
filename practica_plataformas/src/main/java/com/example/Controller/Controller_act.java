package com.example.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.Model_act.User;


@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class Controller_act {

    
    private final List<User> users = new ArrayList<>(); // Lista en memoria que almacena los usuarios.

    
    @PostMapping("/users")
    public ResponseEntity<?> createUser(@RequestBody User user) {

        // Verifica si ya existe un usuario con el mismo ID
        for (User u : users) {
            if (u.getId() == user.getId()) {
                // Retorna código 409 (Conflict) si el ID ya existe
                return ResponseEntity
                        .status(HttpStatus.CONFLICT)
                        .body("El ID ya existe");
            }
        }

        // Agrega el usuario a la lista
        users.add(user);
        System.out.println("código 201 (Created) " + user.getName());

        // Retorna código 201 (Created) con el usuario creado
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

	//listar los usuarios
    @GetMapping("/users")
    public List<User> listUsers() {
        return users;
    }

  
}
