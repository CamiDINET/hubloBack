package com.projet3.hublo.controller;

import com.projet3.hublo.repository.*;
import com.projet3.hublo.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public List<Category> getAll(){ return categoryRepository.findAll(); }

    @GetMapping("/categories/{id}")
    public Category getCategory(@PathVariable Long id){ return categoryRepository.findById(id).get(); }

    @PostMapping("/categories")
    public Category createCategory(@RequestBody Category category){
        return categoryRepository.save(category);
    }
    @PutMapping("/categories/{id}")
    public Category updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category categoryToUpdate = categoryRepository.findById(id).get();
        categoryToUpdate.setName(category.getName());
        return categoryRepository.save(categoryToUpdate);
    }
    @DeleteMapping("categories/{id}")
    public boolean deleteCategoryById(@PathVariable Long id){
        categoryRepository.deleteById(id);
        return true;
    }
}
