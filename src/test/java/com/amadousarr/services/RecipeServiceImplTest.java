package com.amadousarr.services;

import com.amadousarr.domain.Ingredient;
import com.amadousarr.domain.Recipe;
import com.amadousarr.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        recipeService = new RecipeServiceImpl(recipeRepository);
    }

    @Test
    public void getRecipes() {
        Set<Recipe> expectedRecipeList = new HashSet<>();
        //Recipe1 creation
        Recipe recipe1 = new Recipe();
        recipe1.setId(1L);
        recipe1.setDescription("Description of my recipe 1");
        recipe1.setPrepTime(15);




        //Ingredients
        Ingredient carrot = new Ingredient();
        carrot.setId(1L);
        carrot.setDescription("Carrot");
        recipe1.addIngredient(carrot);
        //We save the recipe in the repository

        recipeRepository.save(recipe1);
        // We add the recipe in the list
        expectedRecipeList.add(recipe1);

       when(recipeRepository.findAll()).thenReturn(expectedRecipeList);
       Set<Recipe> recipes = recipeService.getRecipes();
        assertEquals(expectedRecipeList,recipes);
        //Verify that the recipeRepository times once and we
        //are saying the method findAll()
        //we want to very that findAll has been called once, and only once
        verify(recipeRepository,times(1)).findAll();
    }
}