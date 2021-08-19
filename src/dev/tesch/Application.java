package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Crafting.Recipes;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Armors;
import dev.tesch.Items.Consumable;
import dev.tesch.Items.Consumables;
import dev.tesch.Items.Item;
import dev.tesch.Items.Items;
import dev.tesch.Items.Weapon;
import dev.tesch.Items.Weapons;
import dev.tesch.Player.Player;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Application {
    final static String saveFilePath = "src/dev/tesch/save/player/playerStats.txt";
    final static String inventoryFilePath = "src/dev/tesch/save/player/playerInventory.txt";
    public static void main(String[] args) {

        // Actions object and HashMap
        Map<Integer, List<String>> userActions = new Actions().actionsMap;

        // Items, Armors, Weapons, and Consumables objects and HashMaps
        Map<Integer, Item>          items       = new Items().itemsMap;
        Map<Integer, Armor>         armors      = new Armors().armorMap;
        Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
        Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

        // Recipes object and LinkedList
        List<Recipe> recipesList = new Recipes().recipesList;

        // Player object
        Player player = new Player();
        List<Item> inventory = new LinkedList<>();

        Map<String, Integer> playerMap = new HashMap<String, Integer>();

        BufferedReader brP = null;
        BufferedReader brI = null;

        try {
            File saveFile = new File(saveFilePath);
            File inventoryFile = new File(inventoryFilePath);

            brP = new BufferedReader(new FileReader(saveFile));
            brI = new BufferedReader(new FileReader(inventoryFile));

            String line = null;
            int weight = 0;

            while ((line = brP.readLine()) != null) {

                String[] parts = line.split(":");

                String name = parts[0].trim();
                String number = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!name.equals("") && !number.equals(""))
                    playerMap.put(name, Integer.parseInt(number));
            }

            line = null;

            while ((line = brI.readLine()) != null) {

                String[] parts = line.split(":");

                String type = parts[0].trim();
                String itemString = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!type.equals("") && !itemString.equals("")) {
                    Integer itemInt = Integer.parseInt(itemString);
                    if (type.equals("Item"))
                        inventory.add(items.get(itemInt));
                    else if (type.equals("Armor"))
                        inventory.add(armors.get(itemInt));
                    else if (type.equals("Weapon"))
                        inventory.add(weapons.get(itemInt));
                    else if (type.equals("Consumable"))
                        inventory.add(consumables.get(itemInt));
                }
            }

            player.setName("Sean");
            player.setCurrentHealth(playerMap.get("Current Health"));
            player.setMaximumHealth(playerMap.get("Maximum Health"));
            player.setMaximumCarryWeight(playerMap.get("Maximum Weight"));
            player.setArmorClass(playerMap.get("Armor Class"));
            player.setAttackDamage(playerMap.get("Attack Damage"));
            player.setEquippedArmor(playerMap.get("Equipped Armor"));
            if (player.getEquippedArmor() != null)
                player.setHasEquippedArmor(true);
            player.setEquippedWeapon(playerMap.get("Equipped Weapon"));
            if (player.getEquippedWeapon() != null)
                player.setHasEquippedWeapon(true);
            player.setRoomIsIn(playerMap.get("Current Room"));
            player.setKnownRecipes(recipesList);
            player.addToInventory(inventory);
            for (Item item : inventory) {
                weight += item.getItemWeight();
            }
            player.setCurrentCarryWeight(weight);

        } catch (IOException e) {
            System.out.println("An error occurred reading from save file.");
            e.printStackTrace();
        }
        finally {
            if (brP != null && brI != null) {
                try {
                    brP.close();
                    brI.close();
                } catch (Exception e) {
                };
            }
        }

        // Running the main game loop
        ActionsParser.gameLoop(player, userActions);

    }
}
