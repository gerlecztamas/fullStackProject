package com.portfolio.fullStackProject.service;

import com.portfolio.fullStackProject.entity.Recipe;
import com.portfolio.fullStackProject.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;
    @Override
    public List<Recipe> getRecipes() {
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(Long id) {
        return recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Recipe makeRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe changeRecipe(Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @Override
    public void removeRecipe(Long id) {
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        recipeRepository.deleteById(id);
    }
}
