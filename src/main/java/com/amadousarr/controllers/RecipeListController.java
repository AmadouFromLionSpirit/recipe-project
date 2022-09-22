package com.amadousarr.controllers;

import com.amadousarr.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RecipeListController {

    private final RecipeService recipeService;

    public RecipeListController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipeList")
    public String getRecipeList(Model model) {
       model.addAttribute("recipes",recipeService.getRecipes());
        return "recipeList";
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipeById(Long.parseLong(id)));
        return "show";
    }
}
