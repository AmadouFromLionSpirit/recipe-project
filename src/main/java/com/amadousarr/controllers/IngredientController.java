package com.amadousarr.controllers;

import com.amadousarr.services.IngredientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {

    private final IngredientService ingredientService;

    public IngredientController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }
    @RequestMapping("/ingredients")
    public String getIngredients(Model model) {
        model.addAttribute("ingredients", ingredientService.getIngredients());
        return "ingredients";
    }
}
