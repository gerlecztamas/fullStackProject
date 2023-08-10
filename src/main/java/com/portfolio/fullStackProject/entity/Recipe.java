package com.portfolio.fullStackProject.entity;

import com.portfolio.fullStackProject.entity.enums.DifficultyEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "recipe")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "title")
    @NotEmpty(message = "Title is mandatory!")
    private String title;
    @Column(name = "intro")
    @NotEmpty(message = "Intro is mandatory!")
    private String intro;
    @ElementCollection(targetClass = String.class, fetch = FetchType.LAZY)
    @CollectionTable(name = "ingredients", joinColumns = @JoinColumn(name = "recipe_id"))
    @Column(name = "ingredient", nullable = false)
    @NotNull(message = "Ingredients is mandatory!")
    private List<String> ingredients;
    @Column(name = "servings")
    @NotNull(message = "Servings is mandatory!")
    private int servings;
    @Column(name = "duration")
    @NotNull(message = "Duration is mandatory!")
    private int duration;
    @Column(name = "difficulty")
    @NotNull(message = "Difficulty is mandatory!")
    private DifficultyEnum difficulty;
    @Column(name = "method")
    @NotEmpty(message = "Method is mandatory!")
    private String method;
}
