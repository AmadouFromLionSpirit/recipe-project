package com.amadousarr.controllers;

import com.amadousarr.domain.Recipe;
import com.amadousarr.services.RecipeService;
import com.amadousarr.services.RecipeServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class recipeListControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

   RecipeListController recipeListController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        recipeListController = new RecipeListController(recipeService);
    }



    @Test
    public void getRecipeList() {
        String resultExpected = "recipeList";
        assertEquals(resultExpected,recipeListController.getRecipeList(model));

    }
}