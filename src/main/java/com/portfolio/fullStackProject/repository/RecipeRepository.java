package com.portfolio.fullStackProject.repository;

import com.portfolio.fullStackProject.entity.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
