package com.example.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Model.UserManager;
import com.example.Model.UserManager.User;

@RestController
@CrossOrigin(origins = "*")
public class Controller_act {
   
    private final UserManager userManager = new UserManager();      //Instancia del gestor de estudiantes

    @PostMapping("/estudiantes")
    public ResponseEntity<?> createEstudiante(@RequestBody User user) { //Recibe un JSON con id, name y carrera para crear un nuevo estudiante
        try {
            User createdUser = userManager.addUser(user);
            System.out.println("Estudiante creado: " + createdUser.getName());  //201 (Created) si se crea exitosamente, 409 (Conflict) si el ID ya existe
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @GetMapping("/estudiantes")
    public ResponseEntity<List<User>> listEstudiantes() {       //Obtiene la lista de todos los estudiantes registrados.
        return ResponseEntity.ok(userManager.getUsers());
    }
}