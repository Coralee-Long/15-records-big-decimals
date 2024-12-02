package com.exercises.zoo;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Species
        Species lionSpecies = new Species("Lion", 2500); // Lions eat 2500 grams of food per day
        Species elephantSpecies = new Species("Elephant", 4800); // Elephants eat 4800 grams of food per day

        // Owners
        Owner ownerJohn = new Owner("John", "Doe", 40, "john.doe@example.com");
        Owner ownerSarah = new Owner("Sarah", "Connor", 35, "sarah.connor@example.com");
        Owner ownerMike = new Owner("Mike", "Smith", 50, "mike.smith@example.com");

        // Animals (multiple animals of the same species with assigned owners)
        Animal lion1 = new Animal("Leo", "Mammal", true, ownerJohn, lionSpecies);
        Animal lion2 = new Animal("Nala", "Mammal", false, ownerJohn, lionSpecies);
        Animal lion3 = new Animal("Simba", "Mammal", true, ownerSarah, lionSpecies);

        Animal elephant1 = new Animal("Dumbo", "Mammal", true, ownerMike, elephantSpecies);
        Animal elephant2 = new Animal("Ellie", "Mammal", false, ownerMike, elephantSpecies);

        // Add Animals to a List
        List<Animal> animalList = new ArrayList<>();
        animalList.add(lion1);
        animalList.add(lion2);
        animalList.add(lion3);
        animalList.add(elephant1);
        animalList.add(elephant2);

        // Create Zoo
        Zoo zoo = new Zoo(animalList);

        // Print Zoo Information
        System.out.println("Animals in the Zoo: " + zoo.animals());
        System.out.println("Total Food Requirement: " + zoo.calculateTotalFoodRequirement() + " grams/day");

        // Print Animals
        System.out.println(lion1);
        System.out.println(lion2);
        System.out.println(lion3);
        System.out.println(elephant1);
        System.out.println(elephant2);

        // Test Species Assignment
        System.out.println("Do both lions share the same species? " + (lion1.species() == lion2.species())); // true
        System.out.println("Do lion and elephant share the same species? " + (lion1.species() == elephant1.species())); // false

        // Test Owner Assignment
        System.out.println("Do both lions have the same owner? " + (lion1.owner() == lion2.owner())); // true
        System.out.println("Do lion1 and lion3 have the same owner? " + (lion1.owner() == lion3.owner())); // false
    }
}
