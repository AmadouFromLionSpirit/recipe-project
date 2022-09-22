package com.amadousarr.controllers;

import com.amadousarr.services.CategoryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @RequestMapping("/categories")
    public String getCategories(Model model) {
        model.addAttribute("categories",categoryService.getCategories());
        return "categories";
    }
}
