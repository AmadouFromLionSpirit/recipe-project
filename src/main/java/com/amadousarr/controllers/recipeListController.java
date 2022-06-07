package com.amadousarr.controllers;

import com.amadousarr.repositories.RecipeRepository;
import com.amadousarr.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class recipeListController {

    private final RecipeService recipeService;

    public recipeListController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping("/recipeList")
    public String getRecipeList(Model model) {
       model.addAttribute("recipes",recipeService.getRecipes());
        return "recipeList";
    }
}
