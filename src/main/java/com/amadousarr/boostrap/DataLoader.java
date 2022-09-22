package com.amadousarr.boostrap;

import com.amadousarr.domain.*;
import com.amadousarr.repositories.CategoryRepository;
import com.amadousarr.repositories.IngredientRepository;
import com.amadousarr.repositories.RecipeRepository;
import com.amadousarr.repositories.UnitOfMeasureRepository;
import com.amadousarr.services.RecipeService;
import com.amadousarr.services.RecipeServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Optional;

@Component
public class DataLoader implements CommandLineRunner {
    private CategoryRepository categoryRepository;
    private IngredientRepository ingredientRepository;
    private RecipeRepository recipeRepository;
    private UnitOfMeasureRepository unitOfMeasureRepository;

    public DataLoader(CategoryRepository categoryRepository, IngredientRepository ingredientRepository, RecipeRepository recipeRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.recipeRepository = recipeRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    //private Set<Ingredient> ingredients = new HashSet<>();

    @Override
    public void run(String... args) throws Exception {

        //get unit of measures
       Optional<UnitOfMeasure> eachUomOptional = unitOfMeasureRepository.findByDescriptor("Each");
        if(!eachUomOptional.isPresent()) {
            throw new RuntimeException("Expected UOM not Found");
        }
        Optional<UnitOfMeasure> tableSpoonUomOptional = unitOfMeasureRepository.findByDescriptor("Tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected uom not found");
        }
        Optional<UnitOfMeasure> teaSpoonUomOptional = unitOfMeasureRepository.findByDescriptor("Teaspoon");
        if(!teaSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM not found");
        }

        //get optionals
       UnitOfMeasure eachUom = eachUomOptional.get();
        UnitOfMeasure tableSpoonUom = tableSpoonUomOptional.get();
        UnitOfMeasure teaSpoonUom = teaSpoonUomOptional.get();

        //get categories
        Optional<Category> americanUomOptional = categoryRepository.findByDescription("American");
        if(!americanUomOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> mexicanUomOptional = categoryRepository.findByDescription("Mexican");
        if(!mexicanUomOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> italianUomOptional = categoryRepository.findByDescription("Italian");
        if(!italianUomOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        Optional<Category> fastFoodUomOptional = categoryRepository.findByDescription("Fast Food");
        if(!fastFoodUomOptional.isPresent()) {
            throw new RuntimeException("Expected category not found");
        }
        Category americanCategory = americanUomOptional.get();
        Category mexicanCategory = mexicanUomOptional.get();

        //We create the ingredients
        /*Ingredient avocado = new Ingredient();
        avocado.setDescription("avocado");
        Ingredient salt = new Ingredient();
        salt.setDescription("salt");
        Ingredient lime = new Ingredient();
        lime.setDescription("Salt");
        Ingredient redOnion = new Ingredient();
        redOnion.setDescription("red onion");
        Ingredient chili = new Ingredient();
        chili.setDescription("chili");
        Ingredient cilantro = new Ingredient();
        cilantro.setDescription("cilantro");
        Ingredient pepper = new Ingredient();
        pepper.setDescription("pepper");
        Ingredient tomato = new Ingredient();
        tomato.setDescription("tomato");
        Ingredient redRadish = new Ingredient();
        redRadish.setDescription("red radish");

        Ingredient anchoChiliPowder = new Ingredient();
        anchoChiliPowder.setDescription("ancho chili powder");
        Ingredient driedOregano = new Ingredient();
        driedOregano.setDescription("dried oregano");
        Ingredient driedCumin = new Ingredient();
        driedCumin.setDescription("dried Cumin");
*/

        //We save the ingredient in the Ingredient repository
      /*  ingredientRepository.save(avocado);
        ingredientRepository.save(salt);
        ingredientRepository.save(lime);
        ingredientRepository.save(redOnion);
        ingredientRepository.save(chili);
        ingredientRepository.save(cilantro);
        ingredientRepository.save(pepper);
        ingredientRepository.save(tomato);
        ingredientRepository.save(avocado);
        ingredientRepository.save(redRadish);

        ingredientRepository.save(anchoChiliPowder);
        ingredientRepository.save(driedOregano);
        ingredientRepository.save(driedCumin);*/



        //We create our first Recipe
        Recipe guacRecipe = new Recipe();
        guacRecipe.setCookTime(10);
        guacRecipe.setPrepTime(10);
        guacRecipe.setDescription("Perfect Guacamole");
        guacRecipe.setDifficulty(Difficulty.EASY);
        guacRecipe.setUrl("https://www.simplyrecipes.com/recipes/perfect_guacamole/");
        guacRecipe.setDirections(" 1. Cut the avocado:\n" +
                "\n" +
                "Cut the avocados in half. Remove the pit. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl. " +
                " Mash the avocado flesh:\n" +
                "\n" +
                "2. Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.) " +
                " Add the remaining ingredients to taste:\n" +
                "\n" +
                "3. Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" +
                "\n" +
                "4. Add the chopped onion, cilantro, black pepper, and chilis. Chili peppers vary individually in their spiciness. So, start with a half of one chili pepper and add more to the guacamole to your desired degree of heat.\n" +
                "\n" +
                "5. Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste. " +
                " Serve immediately:\n" +
                "\n" +
                "6. If making a few hours ahead, place plastic wrap on the surface of the guacamole and press down to cover it to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) " +
                " Garnish with slices of red radish or jigama strips. Serve with your choice of store-bought tortilla chips or make your own homemade tortilla chips.\n" +
                "\n" +
                "7. Refrigerate leftover guacamole up to 3 days. ");

        //I will add a note to the recipe
        Notes guacNotes = new Notes();
        guacNotes.setRecipeNotes("Be careful handling chilis! If using, it's best to wear food-safe gloves.\n" +
                " If no gloves are available, wash your hands thoroughly after handling, and do not touch your " +
                "eyes or the area near your eyes for several hours afterwards.");



        guacRecipe.setNotes(guacNotes);
        recipeRepository.save(guacRecipe);
        System.out.println("===================== Printing the Notes of the recipe ====================================");
        System.out.println(guacRecipe.getNotes().getRecipeNotes());

        //We add the ingredients to our guacamole recipe
        guacRecipe.addIngredient(new Ingredient("ripe avocados",new BigDecimal(2),eachUom));
        guacRecipe.addIngredient(new Ingredient("kosher salt",new BigDecimal(0.25),teaSpoonUom));
        guacRecipe.addIngredient(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tableSpoonUom));
        //guacRecipe.getIngredients().add(new Ingredient("ripe avocados",new BigDecimal(2),eachUom));
       // guacRecipe.getIngredients().add(new Ingredient("kosher salt",new BigDecimal(0.25),teaSpoonUom));
       // guacRecipe.getIngredients().add(new Ingredient("fresh lime juice or lemon juice",new BigDecimal(1),tableSpoonUom));


       // I save the ingredients
       /* ingredientRepository.save(ingredientOne);
        ingredientRepository.save(ingredientTwo);
        ingredientRepository.save(ingredientThree);*/
      // guacRecipe.setIngredients(guacRecipe.getIngredients());


       /* guacRecipe.getIngredients().add(salt);
        guacRecipe.getIngredients().add(lime);
        guacRecipe.getIngredients().add(redOnion);
        guacRecipe.getIngredients().add(chili);
        guacRecipe.getIngredients().add(cilantro);
        guacRecipe.getIngredients().add(pepper);
        guacRecipe.getIngredients().add(tomato);
        guacRecipe.getIngredients().add(avocado);
        guacRecipe.getIngredients().add(redRadish);*/



        //I add the categories
        guacRecipe.getCategories().add(americanCategory);
        guacRecipe.getCategories().add(mexicanCategory);



        //I save the first recipe
        recipeRepository.save(guacRecipe);

       /* //We create our second recipe
        Recipe recipe2 = new Recipe();
        recipe2.setCookTime(15);
        recipe2.setDescription("\n" +
                "Spicy Grilled Chicken Tacos");
        recipe2.setDifficulty(Difficulty.MODERATE);
        recipe2.setUrl("https://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/");
       *//* recipe2.getIngredients().add(anchoChiliPowder);
        recipe2.getIngredients().add(driedOregano);
        recipe2.getIngredients().add(driedCumin);
*//*
        //I save the second recipe
        recipeRepository.save(recipe2);*/


       // ingredientRepository.findAll().forEach(System.out::println);


       // ingredients.add(avocado);
     /*  */
       // guacRecipe.setIngredients();

        // I want to find all recipes
        RecipeService recipeService = new RecipeServiceImpl(recipeRepository);
        recipeService.getRecipes().forEach(recipe -> System.out.println(recipe.getDescription()));

        // I want to see the categories of the first recipe
        System.out.println("===================================================");
        recipeService.getRecipeById(1L).getCategories().forEach(category -> System.out.println(category.getDescription()));

        System.out.println("========================= Displaying ingredients of the recipe ==============================");
        recipeService.getRecipeById(1l).getIngredients().forEach(ingredient -> System.out.println(ingredient.getDescription()));

    }
}
