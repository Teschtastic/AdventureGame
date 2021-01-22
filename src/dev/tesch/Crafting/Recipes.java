package dev.tesch.Crafting;

import dev.tesch.Items.*;

import java.util.*;

public class Recipes {

    // Different item maps
    Map<Integer, Item>          items       = new Items().itemsMap;
    Map<Integer, Armor>         armors      = new Armors().armorMap;
    Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
    Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

    // Recipes map
    public List<Recipe> recipesList = new LinkedList<>();

    public Recipes() {
        recipesList.add(0, new Recipe(
                new LinkedList<>(Arrays.asList(items.get(2))),
                armors.get(1)
        ));

        recipesList.add(1, new Recipe(
                new LinkedList<>(Arrays.asList(items.get(4), items.get(5))),
                weapons.get(1)
        ));
    }
}
