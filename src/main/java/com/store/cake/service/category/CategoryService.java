package com.store.cake.service.category;

import com.store.cake.entity.Categories;

import java.util.List;

public interface CategoryService {

    public void add(Categories category);

    public void delete(int id);

    public List<Categories> getAllCategories();
}
