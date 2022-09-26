package com.amadousarr.services;

import com.amadousarr.commands.RecipeCommand;
import com.amadousarr.converters.RecipeCommandToRecipe;
import com.amadousarr.converters.RecipeToRecipeCommand;
import com.amadousarr.domain.Recipe;
import com.amadousarr.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {
    private final RecipeRepository recipeRepository;
    private final RecipeCommandToRecipe recipeCommandToRecipe;
    private final RecipeToRecipeCommand recipeToRecipeCommand;

    public RecipeServiceImpl(RecipeRepository recipeRepository, RecipeCommandToRecipe recipeCommandToRecipe, RecipeToRecipeCommand recipeToRecipeCommand) {
        this.recipeRepository = recipeRepository;
        this.recipeCommandToRecipe = recipeCommandToRecipe;
        this.recipeToRecipeCommand = recipeToRecipeCommand;
    }

    @Override
    public Set<Recipe> getRecipes() {
        Set<Recipe>recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;

    }

    public Recipe getRecipeById(Long id) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(id);
        if(!recipeOptional.isPresent()) {
            throw new RuntimeException("Recipe Not Found !");
        }
        return recipeOptional.get();

    }

    @Override
    @Transactional
    public RecipeCommand saveRecipeCommand(RecipeCommand recipeCommand) {
        Recipe detachedRecipe = recipeCommandToRecipe.convert(recipeCommand);

        Recipe savedRecipe = recipeRepository.save(detachedRecipe);
        log.debug("Saved RecipeId: " + savedRecipe.getId());
        return recipeToRecipeCommand.convert(savedRecipe);
    }
}
