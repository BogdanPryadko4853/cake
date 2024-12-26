package com.store.cake.controller;

import com.store.cake.entity.Cake;
import com.store.cake.entity.Categories;
import com.store.cake.entity.Image;
import com.store.cake.service.cake.CakeServiceImpl;
import com.store.cake.service.category.CategoryServiceImpl;
import com.store.cake.service.image.ImageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/api/v1/cakes")
public class CakeController {

    @Autowired
    private CakeServiceImpl cakeService;

    @Autowired
    private ImageServiceImpl imageService;

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public String findAll(@RequestParam(defaultValue = "0") int page,
                          @RequestParam(defaultValue = "10") int size,
                          Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cake> cakes = cakeService.getAllCake(pageable);
        model.addAttribute("cakes", cakes);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "cakes";
    }

    @GetMapping("/category/{categoryId}")
    public String getCakesByCategory(@PathVariable int categoryId,
                                     @RequestParam(defaultValue = "0") int page,
                                     @RequestParam(defaultValue = "10") int size,
                                     Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cake> cakes = cakeService.getCakesByCategory(categoryId, pageable);
        model.addAttribute("cakes", cakes);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategoryId", categoryId); // Добавляем выбранную категорию
        return "cakes";
    }



    @GetMapping("/categories")
    public String showCategories() {
        return "categories"; // Возвращает имя HTML-шаблона (categories.html)
    }

    @GetMapping("/{id}")
    public String getCake(@PathVariable int id, Model model) {
        Cake cake = cakeService.getCake(id);
        String imageBase64 = convertImageToBase64(cake.getImage().getImage());
        model.addAttribute("cake", cake);
        model.addAttribute("imageBase64", imageBase64);
        return "cake";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        List<Categories> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "create-cake";
    }

    @PostMapping
    public String createCake(@RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") String price,
                             @RequestParam("image") MultipartFile imageFile,
                             @RequestParam("categories") Set<Integer> categoryIds) {
        try {
            // Создание торта
            Cake cake = new Cake();
            cake.setName(name);
            cake.setDescription(description);
            cake.setPrice(price);

            // Обработка изображения
            Image image = new Image();
            image.setImage(imageFile.getBytes());
            imageService.saveImage(image);
            cake.setImage(image);

            // Добавление категорий
            Set<Categories> categories = new HashSet<>();
            for (Integer categoryId : categoryIds) {
                Categories category = categoryService.getCategoryById(categoryId);
                categories.add(category);
            }
            cake.setCategories(categories);

            // Сохранение торта
            cakeService.addCake(cake);

            return "redirect:/admin"; // Перенаправление на страницу админа
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin?error"; // Перенаправление с ошибкой
        }
    }

    @PostMapping("/{id}/delete")
    public String deleteCake(@PathVariable int id) {
        cakeService.deleteCake(id);
        return "redirect:/admin"; // Перенаправление на страницу админа
    }

    @PostMapping("/{id}/update")
    public String updateCake(@PathVariable int id,
                             @RequestParam("name") String name,
                             @RequestParam("description") String description,
                             @RequestParam("price") String price,
                             @RequestParam("image") MultipartFile imageFile,
                             @RequestParam("categories") Set<Integer> categoryIds) {
        try {
            Cake cake = cakeService.getCake(id);
            cake.setName(name);
            cake.setDescription(description);
            cake.setPrice(price);

            if (!imageFile.isEmpty()) {
                Image image = cake.getImage();
                image.setImage(imageFile.getBytes());
                imageService.saveImage(image);
            }

            // Обновление категорий
            Set<Categories> categories = new HashSet<>();
            for (Integer categoryId : categoryIds) {
                Categories category = categoryService.getCategoryById(categoryId);
                categories.add(category);
            }
            cake.setCategories(categories);

            cakeService.updateCake(cake);

            return "redirect:/admin"; // Перенаправление на страницу админа
        } catch (IOException e) {
            e.printStackTrace();
            return "redirect:/admin?error"; // Перенаправление с ошибкой
        }
    }

    private String convertImageToBase64(byte[] image) {
        return Base64.getEncoder().encodeToString(image);
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable int id, Model model) {
        Cake cake = cakeService.getCake(id);
        String imageBase64 = convertImageToBase64(cake.getImage().getImage());
        model.addAttribute("cake", cake);
        model.addAttribute("imageBase64", imageBase64);
        List<Categories> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "edit-cake";
    }

    @GetMapping("/reset")
    public String resetFilter(@RequestParam(defaultValue = "0") int page,
                              @RequestParam(defaultValue = "10") int size,
                              Model model) {
        Pageable pageable = PageRequest.of(page, size);
        Page<Cake> cakes = cakeService.getAllCake(pageable);
        model.addAttribute("cakes", cakes);
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("selectedCategoryId", null); // Сбрасываем выбранную категорию
        return "cakes";
    }
}