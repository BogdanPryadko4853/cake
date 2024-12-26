package com.store.cake.controller;

import com.store.cake.entity.Categories;
import com.store.cake.service.category.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequestMapping("/api/v1/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    // Получить все категории
    @GetMapping("")
    public String getAllCategories(Model model) {
        List<Categories> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "categories";
    }

    // Удалить категорию по ID
    @PostMapping("/{id}")
    public String deleteCategoryById(@PathVariable int id) {
        categoryService.deleteCategoryById(id);
        return "redirect:/api/v1/categories";
    }

    // Добавить новую категорию
    @PostMapping
    public String addCategory(@RequestParam("name") String name) {
        Categories category = new Categories();
        category.setName(name);
        categoryService.saveCategory(category);
        return "redirect:/api/v1/categories";
    }
}