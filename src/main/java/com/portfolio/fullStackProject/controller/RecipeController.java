package com.portfolio.fullStackProject.controller;

import com.portfolio.fullStackProject.entity.Recipe;
import com.portfolio.fullStackProject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class RecipeController {
    private final RecipeService recipeService;

    private static final Logger LOGGER = LogManager.getLogger(RecipeController.class);

    @RequestMapping(value = "/getRecipes", method = RequestMethod.GET)
    public ResponseEntity<?> getRecipes(){
        try{
            LOGGER.info("getRecipes method called in controller");
            List<Recipe> donations = recipeService.getRecipes();
            return new ResponseEntity<>(donations, HttpStatus.OK);
        }
        catch (Exception ex){
            LOGGER.error("Error: ", ex);
            return new ResponseEntity<>("There was an error!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/makeRecipe", method = RequestMethod.POST)
    public ResponseEntity<?> makeRecipe(@RequestBody Recipe recipe){
        try{
            LOGGER.info("makeRecipe method called in controller");
            Recipe newRecipe = recipeService.makeRecipe(recipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        }
        catch (Exception ex){
            LOGGER.error("Error: ", ex);
            return new ResponseEntity<>("There was an error!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getRecipe/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRecipeById(@PathVariable Long id){
        try{
            LOGGER.info("getRecipe method called in controller");
            Recipe recipe = recipeService.getRecipe(id);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        catch (Exception ex){
            LOGGER.error("Error: ", ex);
            return new ResponseEntity<>("There was an error!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/changeRecipe", method = RequestMethod.PUT)
    public ResponseEntity<?> changeRecipe(@RequestBody Recipe recipe){
        try{
            LOGGER.info("changeRecipe method called in controller");
            Recipe changedRecipe = recipeService.changeRecipe(recipe);
            return new ResponseEntity<>(changedRecipe, HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            LOGGER.error("Error: ", ex);
            return new ResponseEntity<>("There was an error!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/deleteRecipe/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id){
        try{
            LOGGER.info("deleteRecipe method called in controller");
            recipeService.removeRecipe(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            LOGGER.error("Error: ", ex);
            return new ResponseEntity<>("There was an error!", HttpStatus.NOT_FOUND);
        }
    }
}
