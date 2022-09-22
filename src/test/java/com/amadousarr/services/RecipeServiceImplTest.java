package com.amadousarr.services;

import com.amadousarr.domain.Ingredient;
import com.amadousarr.domain.Recipe;
import com.amadousarr.repositories.RecipeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;
@ExtendWith(MockitoExtension.class)
public class RecipeServiceImplTest {
    @InjectMocks
    RecipeServiceImpl recipeService;
    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp() throws Exception {
       // MockitoAnnotations.openMocks(this);
       // recipeService = new RecipeServiceImpl(recipeRepository);
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
        recipe1.getIngredients().add(carrot);
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

    @Test
    public void getRecipeById() {
     /*   Set<Recipe> recipes ;
        recipes = new HashSet<>();
        recipes.add(Recipe.builder().id(1L).description("fake recipe").build());
        when(recipeRepository.findById(anyLong())).thenReturn(recipes);
        assertEquals(1L, recipeService.getRecipeById(1L));*/
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> recipeOptional = Optional.of(recipe);
        when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
        Recipe recipeReturned = recipeService.getRecipeById(1L);
        assertNotNull(recipeReturned, "Null recipe returned");
        verify(recipeRepository, times(1)).findById(anyLong());
        verify(recipeRepository, never()).findAll();

    }
}