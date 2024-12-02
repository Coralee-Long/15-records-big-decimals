package com.exercises.zoo;

import java.util.List;

public record Zoo(List<Animal> animals) {
    public int calculateTotalFoodRequirement() {
        int totalFood = 0;
        for (Animal animal : animals) {
            totalFood += animal.species().foodRequirementInGrams();
        }
        return totalFood;
    }
}

