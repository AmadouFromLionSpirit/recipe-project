package com.amadousarr.services;

import com.amadousarr.commands.RecipeCommand;
import com.amadousarr.domain.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
    Recipe getRecipeById(Long id);

    RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand);
}
