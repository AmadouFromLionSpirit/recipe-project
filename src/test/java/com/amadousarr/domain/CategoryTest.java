package com.amadousarr.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class CategoryTest {
  //  Let's create a property for category
    Category category;
    @BeforeEach
    public void setUp() {
        category= new Category();
    }

    @Test
    public void getId() {
        Long expected = 9L;
        Long idValue = 9L;
        category.setId(idValue);
        assertEquals(expected,category.getId());
    }

   @Disabled
    public void getDescription() {
        fail("The test has yet to be implemented");
    }

    @Disabled
    public void getRecipes() {
        fail("The test has yet to be implemented");
    }
}