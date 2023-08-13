package com.portfolio.fullStackProject.service;

import com.portfolio.fullStackProject.controller.RecipeController;
import com.portfolio.fullStackProject.entity.Recipe;
import com.portfolio.fullStackProject.repository.RecipeRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeServiceImpl implements RecipeService{

    private final RecipeRepository recipeRepository;

    private static final Logger LOGGER = LogManager.getLogger(RecipeController.class);

    @Override
    public List<Recipe> getRecipes() {
        LOGGER.info("getRecipes method called in service");
        return recipeRepository.findAll();
    }

    @Override
    public Recipe getRecipe(Long id) {
        LOGGER.info("getRecipe method called in service");
        return recipeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public Recipe makeRecipe(Recipe recipe) {
        LOGGER.info("makeRecipe method called in service");
        return recipeRepository.save(recipe);
    }

    @Override
    public Recipe changeRecipe(Recipe recipe) {
        LOGGER.info("changeRecipe method called in service");
        return recipeRepository.save(recipe);
    }

    @Override
    public void removeRecipe(Long id) {
        LOGGER.info("removeRecipe method called in service");
        Recipe recipe = recipeRepository.findById(id)
                .orElseThrow(EntityNotFoundException::new);
        recipeRepository.deleteById(id);
    }
}
