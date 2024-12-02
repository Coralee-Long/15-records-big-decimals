package com.exercises.zoo;

public record Animal(String name,
                     String type,
                     boolean isMale,
                     Owner owner,
                     Species species) {
}
