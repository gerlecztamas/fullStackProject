package com.portfolio.fullStackProject.controller;

import com.portfolio.fullStackProject.entity.Recipe;
import com.portfolio.fullStackProject.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class RecipeController {
    private final RecipeService recipeService;
    @RequestMapping(value = "/getRecipes", method = RequestMethod.GET)
    public ResponseEntity<?> getRecipes(){
        try{
            List<Recipe> donations = recipeService.getRecipes();
            return new ResponseEntity<>(donations, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Hiba történt!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/makeRecipe", method = RequestMethod.POST)
    public ResponseEntity<?> makeRecipe(@RequestBody Recipe recipe){
        try{
            Recipe newRecipe = recipeService.makeRecipe(recipe);
            return new ResponseEntity<>(newRecipe, HttpStatus.CREATED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Hiba történt!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/getRecipe/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getRecipeById(@PathVariable Long id){
        try{
            Recipe recipe = recipeService.getRecipe(id);
            return new ResponseEntity<>(recipe, HttpStatus.OK);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Hiba történt!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/changeRecipe", method = RequestMethod.PUT)
    public ResponseEntity<?> changeRecipe(@RequestBody Recipe recipe){
        try{
            Recipe changedRecipe = recipeService.changeRecipe(recipe);
            return new ResponseEntity<>(changedRecipe, HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Hiba történt!", HttpStatus.BAD_REQUEST);
        }
    }

    @RequestMapping(value = "/deleteRecipe/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteRecipe(@PathVariable Long id){
        try{
            recipeService.removeRecipe(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        }
        catch (Exception ex){
            return new ResponseEntity<>("Hiba történt!", HttpStatus.NOT_FOUND);
        }
    }
}
