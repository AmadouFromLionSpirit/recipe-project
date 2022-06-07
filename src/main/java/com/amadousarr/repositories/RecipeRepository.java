package com.amadousarr.repositories;

import com.amadousarr.domain.Recipe;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RecipeRepository extends CrudRepository<Recipe,Long> {
    Optional<Recipe> findByDescription(String description);
}
