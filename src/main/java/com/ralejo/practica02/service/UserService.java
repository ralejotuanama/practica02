package com.ralejo.practica02.service;

import com.ralejo.practica02.model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();
    private Long idCounter = 1L;

    // Obtener todos los usuarios
    public List<User> getAllUsers() {
        return users;
    }

    // Agregar un usuario
    public User addUser(User user) {
        user.setId(idCounter++);
        users.add(user);
        return user;
    }

    // Obtener un usuario por ID
    public Optional<User> getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }

    // Eliminar un usuario por ID
    public boolean deleteUser(Long id) {
        return users.removeIf(user -> user.getId().equals(id));
    }

}
