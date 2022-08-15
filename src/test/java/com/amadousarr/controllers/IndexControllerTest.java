package com.amadousarr.controllers;

import com.amadousarr.services.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.ui.Model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

class IndexControllerTest {
    IndexController indexController;
    @Mock
    RecipeService recipeService;
    @Mock
    Model model;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        indexController = new IndexController(recipeService);
    }

    @Test
    void testMockMVC() throws Exception {
        /**
         * The first thing we want to do is to create a MockMvc, we can use a Builder, we want to use MockMvcBuilder
         * now we have two options standaloneSetup and webContextSetup( that's going to bring us the spring Context
         * and our test will no longer be a unit test), but with standalone test we can do and keep our
         * tests running nice and fast, what's gonna ask for is a controller or a set of controllers and at the end
         * we will add a build.
         */
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
        /**
         * We wanna say get from root context and then we can say andExpect we get back a 200 status from our controller
         * and expect we have a view where the name is index
         */
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void getIndexPage() {
        String resultExpected = "index";
        String viewName = indexController.getIndexPage(model);
        assertEquals(resultExpected, viewName);
        verify(recipeService, times(1)).getRecipes();
        verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
    }
}