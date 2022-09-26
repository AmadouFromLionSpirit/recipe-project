package com.amadousarr.converters;

import com.amadousarr.commands.RecipeCommand;
import com.amadousarr.domain.Recipe;
import lombok.Synchronized;
import org.springframework.core.convert.converter.Converter;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

@Component
public class RecipeCommandToRecipe implements Converter<RecipeCommand, Recipe> {
    private final CategoryCommandToCategory categoryConverter;
    private final IngredientCommandToIngredient ingredientConverter;
    private final NotesCommandToNotes notesConverter;

    public RecipeCommandToRecipe(CategoryCommandToCategory categoryConverter, IngredientCommandToIngredient ingredientConverter, NotesCommandToNotes notesConverter) {
        this.categoryConverter = categoryConverter;
        this.ingredientConverter = ingredientConverter;
        this.notesConverter = notesConverter;
    }
    @Synchronized
    @Nullable
    @Override
    public Recipe convert(RecipeCommand recipeCommand) {
        if(recipeCommand == null) {
            return null;
        }
         final Recipe recipe = new Recipe();
        recipe.setId(recipeCommand.getId());
        recipe.setCookTime(recipeCommand.getCookTime());
        recipe.setPrepTime(recipeCommand.getPrepTime());
        recipe.setDescription(recipeCommand.getDescription());
        recipe.setDifficulty(recipeCommand.getDifficulty());
        recipe.setDirections(recipeCommand.getDirections());
        recipe.setServings(recipeCommand.getServings());
        recipe.setSource(recipeCommand.getSource());
        recipe.setUrl(recipeCommand.getUrl());
        recipe.setNotes(notesConverter.convert(recipeCommand.getNotes()));

        recipeCommand.getIngredients().forEach(ingredientCommand -> recipe.getIngredients().add(ingredientConverter.convert(ingredientCommand)));
        recipeCommand.getCategories().forEach(categoryCommand -> recipe.getCategories().add(categoryConverter.convert(categoryCommand)));
        return recipe;


    }
}
