package dev.tesch.Crafting;

import dev.tesch.AllObjects;

import java.util.*;

public class Recipes {

    // All Objects object
    AllObjects allObjects = new AllObjects();

    // Recipes map
    public List<Recipe> recipesList = new LinkedList<>();

    public Recipes() {
        recipesList.add(0, new Recipe(
                new LinkedList<>(Arrays.asList(allObjects.allItems.items.get(1), allObjects.allItems.items.get(1))),
                allObjects.allItems.armors.get(1)
        ));

        recipesList.add(1, new Recipe(
                new LinkedList<>(Arrays.asList(allObjects.allItems.items.get(3), allObjects.allItems.items.get(4))),
                allObjects.allItems.weapons.get(1)
        ));
    }
}
