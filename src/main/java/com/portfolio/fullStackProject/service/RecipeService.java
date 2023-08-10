package com.portfolio.fullStackProject.service;

import com.portfolio.fullStackProject.entity.Recipe;

import java.util.List;

public interface RecipeService {
    List<Recipe> getRecipes();
    Recipe getRecipe(Long id);
    Recipe makeRecipe(Recipe recipe);
    Recipe changeRecipe(Recipe recipe);
    void removeRecipe(Long id);
}
