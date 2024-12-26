package com.store.cake.service.user;

import com.store.cake.entity.Role;
import com.store.cake.entity.User;
import com.store.cake.repository.RoleRepository;
import com.store.cake.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, RoleRepository roleRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(String username, String password) {
        // Проверяем, существует ли пользователь с таким именем
        if (userRepository.findByUsername(username).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        // Создаем нового пользователя
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password)); // Хэшируем пароль

        // Находим роль USER в базе данных
        Role userRole = roleRepository.findByName("USER");

        // Присваиваем роль USER
        user.setRoles(Set.of(userRole));

        // Сохраняем пользователя в базу данных
        userRepository.save(user);
    }
}