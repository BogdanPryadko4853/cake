package com.store.cake.controller;

import com.store.cake.service.cake.CakeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private CakeServiceImpl cakeService;

    @GetMapping
    public String adminPanel(Model model) {
        model.addAttribute("cakes", cakeService.getAllCake());
        return "admin";
    }
}