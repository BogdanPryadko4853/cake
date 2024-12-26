package com.store.cake.security;

import com.store.cake.service.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password) {
        try {
            userService.registerUser(username, password);
            return "redirect:/login?success"; // Перенаправляем на страницу логина с сообщением об успехе
        } catch (Exception e) {
            return "redirect:/register?error"; // Перенаправляем на страницу регистрации с сообщением об ошибке
        }
    }
}