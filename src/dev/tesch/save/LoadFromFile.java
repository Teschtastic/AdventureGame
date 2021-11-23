package dev.tesch.save;

import dev.tesch.AllItems;
import dev.tesch.AllObjects;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Crafting.Recipes;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.io.*;
import java.util.*;

public class LoadFromFile {

    public static void LoadPlayerFromFile(Player player) {
        final String saveFilePath = "src/dev/tesch/save/player/playerStats.txt";
        final String inventoryFilePath = "src/dev/tesch/save/player/playerInventory.txt";

        List<Item> inventory = new LinkedList<>();

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
                            inventory.add(player.getAllObjects().allItems.items.get(itemInt));
                            break;
                        case "Armor":
                            inventory.add(player.getAllObjects().allItems.armors.get(itemInt));
                            break;
                        case "Weapon":
                            inventory.add(player.getAllObjects().allItems.weapons.get(itemInt));
                            break;
                        case "Consumable":
                            inventory.add(player.getAllObjects().allItems.consumables.get(itemInt));
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

    public static void LoadRoomsFromFile(Map<Integer, Room> rooms, AllObjects allObjects) {
        final String roomFilePath = "src/dev/tesch/save/rooms/rooms.txt";

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
                        it = allObjects.allItems.items.get(Integer.parseInt(item));
                        break;
                    case "C":
                        it = allObjects.allItems.consumables.get(Integer.parseInt(item));
                        break;
                    case "A":
                        it = allObjects.allItems.armors.get(Integer.parseInt(item));
                        break;
                    case "W":
                        it = allObjects.allItems.weapons.get(Integer.parseInt(item));
                        break;
                    case "NA":
                        it = null;
                        break;
                }

                switch (NPCType) {
                    case "N":
                        np = allObjects.npcs.get(Integer.parseInt(NPC));
                        break;
                    case "NA":
                        np = null;
                        break;
                }

                switch (furnitureType) {
                    case "F":
                        fur = allObjects.furnitures.get(Integer.parseInt(furniture));
                        break;
                    case "C":
                        fur = allObjects.containers.get(Integer.parseInt(furniture));
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

    public static void LoadConnectedRooms(Map<Integer, Room> rooms) {
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

    public static void LoadContainersFromFile(Map<Integer, Container> containers) {
        final String containerFilePath = "src/dev/tesch/save/furniture/containers.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(containerFilePath), 16*1024);
            Scanner read = new Scanner(in);
            read.useDelimiter(":");
            String container, name, description, message, canUse;

            while(read.hasNext())
            {
                container = read.next().trim();
                name = read.next().trim();
                description = read.next().trim();
                message = read.next().trim();
                canUse = read.next().trim();

                containers.put(Integer.parseInt(container), new Container(
                        name,
                        description,
                       "\n" + message,
                        Boolean.parseBoolean(canUse),
                        new LinkedList<>()));
            }
            read.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void LoadContainersInRoomInventory(Map<Integer, Room> roomsMap, Map<Integer, Container> containers, AllItems allItems) {
        final String containerInventoryPath = "src/dev/tesch/save/furniture/containerInventory.txt";

        try {
            BufferedReader in = new BufferedReader(new FileReader(containerInventoryPath), 16*1024);
            Scanner read = new Scanner(in);
            read.useDelimiter("-");
            String room = null;
            ArrayList<String> rooms = new ArrayList<>();
            ArrayList<String> items = new ArrayList<>();
            List<Item> inventory = new LinkedList<>();
            while(read.hasNext()) {
                rooms.add(read.next().trim());
            }

            for (String r: rooms) {
                items.add(Arrays.toString(r.split(":")));
            }

            for (String i: items) {

                String[] split = i.split(",");
                for (String s: split) {

                    String sT = s.trim().replace("[", "").replace("]", "");
                    String[] sTS = sT.split(";");

                    switch (sTS[0]) {
                        case "R":
                            room = sTS[1];
                            break;
                        case "I":
                            inventory.add(allItems.items.get(Integer.parseInt(sTS[1])));
                            break;
                        case "C":
                            inventory.add(allItems.consumables.get(Integer.parseInt(sTS[1])));
                            break;
                        case "A":
                            inventory.add(allItems.armors.get(Integer.parseInt(sTS[1])));
                            break;
                        case "W":
                            inventory.add(allItems.weapons.get(Integer.parseInt(sTS[1])));
                            break;
                    }
                }

                for (Map.Entry<Integer, Room> roomEntry : roomsMap.entrySet()) {
                    if (Objects.equals(roomsMap.get(Integer.parseInt(Objects.requireNonNull(room))), roomEntry.getValue())) {
                        for (Map.Entry<Integer, Container> containerEntry: containers.entrySet()) {
                            if (Objects.equals(roomEntry.getValue().getFurnitureInRoom(), containerEntry.getValue())) {
                                containers.get(containerEntry.getKey()).addToInventory(inventory);
                            }
                        }
                    }
                }
                inventory.clear();
            }

            read.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
