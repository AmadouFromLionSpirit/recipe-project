package com.amadousarr.controllers;

import com.amadousarr.domain.Recipe;
import com.amadousarr.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class recipeListControllerTest {
    @Mock
    RecipeService recipeService;

    @Mock
    Model model;
    @InjectMocks
   RecipeListController recipeListController;

    @BeforeEach
    public void setUp() throws Exception {
       // MockitoAnnotations.openMocks(this);
      //  recipeListController = new RecipeListController(recipeService);
    }



    @Test
    public void getRecipeList() {
        String resultExpected = "recipeList";
        assertEquals(resultExpected,recipeListController.getRecipeList(model));

    }

    @Test
    public void getRecipe() throws Exception {
        Recipe recipe = new Recipe();
        recipe.setId(1L);

        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(recipeListController).build();
        when(recipeService.getRecipeById(anyLong())).thenReturn(recipe);
        mockMvc.perform(get("/recipe/show/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("show"))
                .andExpect(model().attributeExists("recipe"));
    }
}