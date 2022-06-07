package com.amadousarr.repositories;

import com.amadousarr.domain.Category;
import com.amadousarr.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient,Long> {
    Optional<Ingredient> findByDescription(String description);


}
