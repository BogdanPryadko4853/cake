package com.store.cake.service.category;

import com.store.cake.entity.Categories;
import com.store.cake.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    @Autowired
    private CategoryRepository categoriesRepository;


    public List<Categories> getAllCategories() {
        return categoriesRepository.findAll();
    }

    public Categories getCategoryById(int id) {
        return categoriesRepository.findById(id)
                .orElseThrow(()->new RuntimeException("not found"));
    }

    public void saveCategory(Categories category) {
        categoriesRepository.save(category);
    }

    public void deleteCategoryById(int id) {
        categoriesRepository.deleteById(id);
    }

    public void deleteAllCategories() {
        categoriesRepository.deleteAll();
    }
}