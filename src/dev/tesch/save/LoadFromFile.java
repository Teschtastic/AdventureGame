package dev.tesch.save;

import dev.tesch.Crafting.Recipe;
import dev.tesch.Crafting.Recipes;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Containers;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Furniture.Furnitures;
import dev.tesch.Items.*;
import dev.tesch.NPCs.NPC;
import dev.tesch.NPCs.NPCs;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.io.*;
import java.util.*;

public class LoadFromFile {

    public static void loadPlayerFromFile(Player player) {
        final String saveFilePath = "src/dev/tesch/save/player/playerStats.txt";
        final String inventoryFilePath = "src/dev/tesch/save/player/playerInventory.txt";

        List<Item> inventory = new LinkedList<>();

        // Items, Armors, Weapons, and Consumables objects and HashMaps
        Map<Integer, Item>          items       = new Items().itemsMap;
        Map<Integer, Armor>         armors      = new Armors().armorMap;
        Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
        Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

        // Recipes object and LinkedList
        List<Recipe> recipesList = new Recipes().recipesList;

        Map<String, Integer> playerMap = new HashMap<>();

        BufferedReader brP = null;
        BufferedReader brI = null;

        try {
            File saveFile = new File(saveFilePath);
            File inventoryFile = new File(inventoryFilePath);

            brP = new BufferedReader(new FileReader(saveFile));
            brI = new BufferedReader(new FileReader(inventoryFile));

            String line;
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

            while ((line = brI.readLine()) != null) {

                String[] parts = line.split(":");

                String type = parts[0].trim();
                String itemString = parts[1].trim();

                // put name, number in HashMap if they are
                // not empty
                if (!type.equals("") && !itemString.equals("")) {
                    Integer itemInt = Integer.parseInt(itemString);
                    switch (type) {
                        case "Item":
                            inventory.add(items.get(itemInt));
                            break;
                        case "Armor":
                            inventory.add(armors.get(itemInt));
                            break;
                        case "Weapon":
                            inventory.add(weapons.get(itemInt));
                            break;
                        case "Consumable":
                            inventory.add(consumables.get(itemInt));
                            break;
                    }
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
            System.out.println("An error occurred reading from save file." + e);
        }
        finally {
            if (brP != null && brI != null) {
                try {
                    brP.close();
                    brI.close();
                } catch (Exception e) {
                    System.out.println("Error closing files. " + e);
                }
            }
        }
    }

    public static void loadRoomsFromFile(Map<Integer, Room>  rooms) {
        final String roomFilePath = "src/dev/tesch/save/rooms/rooms.txt";

        // Different item maps
        Map<Integer, Item>          items       = new Items().itemsMap;
        Map<Integer, Armor>         armors      = new Armors().armorMap;
        Map<Integer, Weapon>        weapons     = new Weapons().weaponMap;
        Map<Integer, Consumable>    consumables = new Consumables().consumablesMap;

        // Different NPC maps
        Map<Integer, NPC>           npcs        = new NPCs().npcMap;

        // Different furniture maps
        Map<Integer, Furniture>     furnitures  = new Furnitures().furnituresMap;
        Map<Integer, Container>     containers  = new Containers().containersMap;

        try {
            BufferedReader in = new BufferedReader(new FileReader(roomFilePath), 16*1024);
            Scanner read = new Scanner(in);
            read.useDelimiter(":");
            String room, name, hasItem, itemType, item, hasNPC, NPCType, NPC, hasFurniture,
                    furnitureType, furniture;

            Item it = null;
            NPC np = null;
            Furniture fur = null;

            while(read.hasNext())
            {
                room = read.next().trim();
                name = read.next().trim();
                hasItem = read.next().trim();
                itemType = read.next().trim();
                item = read.next().trim();
                hasNPC = read.next().trim();
                NPCType = read.next().trim();
                NPC = read.next().trim();
                hasFurniture = read.next().trim();
                furnitureType = read.next().trim();
                furniture = read.next().trim();

                switch (itemType) {
                    case "I":
                        it = items.get(Integer.parseInt(item));
                        break;
                    case "C":
                        it = consumables.get(Integer.parseInt(item));
                        break;
                    case "A":
                        it = armors.get(Integer.parseInt(item));
                        break;
                    case "W":
                        it = weapons.get(Integer.parseInt(item));
                        break;
                    case "NA":
                        it = null;
                        break;
                }

                switch (NPCType) {
                    case "N":
                        np = npcs.get(Integer.parseInt(NPC));
                        break;
                    case "NA":
                        np = null;
                        break;
                }

                switch (furnitureType) {
                    case "F":
                        fur = furnitures.get(Integer.parseInt(furniture));
                        break;
                    case "C":
                        fur = containers.get(Integer.parseInt(furniture));
                        break;
                    case "NA":
                        fur = null;
                        break;
                }

                rooms.put(Integer.parseInt(room), new Room(
                        name,
                        Boolean.parseBoolean(hasItem),
                        it,
                        Boolean.parseBoolean(hasNPC),
                        np,
                        Boolean.parseBoolean(hasFurniture),
                        fur));
            }
            read.close();

            LoadConnectedRooms(rooms);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void LoadConnectedRooms(Map<Integer, Room>  rooms) {
        final String connectedRoomFilePath = "src/dev/tesch/save/rooms/connectedRooms.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(connectedRoomFilePath), 16*1024);
            Scanner read = new Scanner(in);
            read.useDelimiter(":");
            String room, north, east, south, west;

            while(read.hasNext())
            {
                room = read.next().trim();
                north = read.next().trim();
                east = read.next().trim();
                south = read.next().trim();
                west = read.next().trim();

                Room N = "null".equalsIgnoreCase(north) ? null : rooms.get(Integer.parseInt(north));
                Room E = "null".equalsIgnoreCase(east) ? null : rooms.get(Integer.parseInt(east));
                Room S = "null".equalsIgnoreCase(south) ? null : rooms.get(Integer.parseInt(south));
                Room W = "null".equalsIgnoreCase(west) ? null : rooms.get(Integer.parseInt(west));

                rooms.get(Integer.parseInt(room)).setConnRooms(
                        new HashMap<>() {{
                            put("N", N);
                            put("E", E);
                            put("S", S);
                            put("W", W);
                        }}
                );
            }
            read.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
