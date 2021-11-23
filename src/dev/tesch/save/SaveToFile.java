package dev.tesch.save;

import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Consumable;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.io.FileWriter;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SaveToFile {
    public static void savePlayerToFile(Player player) {
        final String saveFilePath       = "src/dev/tesch/save/player/playerStats.txt";
        final String inventoryFilePath  = "src/dev/tesch/save/player/playerInventory.txt";

        try {
            FileWriter playerWriter     = new FileWriter(saveFilePath);
            FileWriter inventoryWriter  = new FileWriter(inventoryFilePath);

            playerWriter.write( "Current Health:"    + player.getCurrentHealth()         + "\n" +
                                    "Maximum Health:"    + player.getMaximumHealth()         + "\n" +
                                    "Current Weight:"    + player.getCurrentCarryWeight()    + "\n" +
                                    "Maximum Weight:"    + player.getMaximumCarryWeight()    + "\n" +
                                    "Armor Class:"       + player.getArmorClass()            + "\n" +
                                    "Attack Damage:"     + player.getAttackDamage()          + "\n" +
                                    "Equipped Armor:"    + player.getArmorIndex()            + "\n" +
                                    "Equipped Weapon:"   + player.getWeaponIndex()           + "\n" +
                                    "Current Room:"      + player.getRoomIndex());

            playerWriter.close();

            for (Item item : player.getInventory()) {
                if (item.getClass() == Armor.class) {
                    for (Map.Entry<Integer, Armor> entry : player.getAllObjects().allItems.armors.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Armor:" + entry.getKey() + "\n");
                        }
                    }
                } else if (item.getClass() == Weapon.class) {
                    for (Map.Entry<Integer, Weapon> entry : player.getAllObjects().allItems.weapons.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Weapon:" + entry.getKey() + "\n");
                        }
                    }
                } else if (item.getClass() == Consumable.class) {
                    for (Map.Entry<Integer, Consumable> entry : player.getAllObjects().allItems.consumables.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Consumable:" + entry.getKey() + "\n");
                        }
                    }
                } else {
                    for (Map.Entry<Integer, Item> entry : player.getAllObjects().allItems.items.entrySet()) {
                        if (Objects.equals(item, entry.getValue())) {
                            inventoryWriter.write("Item:" + entry.getKey() + "\n");
                        }
                    }
                }
            }

            inventoryWriter.close();

        } catch (IOException e) {
            System.out.println("An error occurred while writing to save file. " + e);
        }
    }

    public static void saveRoomsToFile(Player player) {
        final String saveRoomFilePath = "src/dev/tesch/save/rooms/rooms.txt";

        try {
            FileWriter roomWrite = new FileWriter(saveRoomFilePath);

            for (Map.Entry<Integer, Room> e : player.getRooms().entrySet()) {
                Integer k = e.getKey();
                Room v = e.getValue();
                String itemChar = "NA", npcChar = "NA", furnitureChar = "NA",
                        itemNum = null, npcNum = null, furnitureNum = null;

                Item item = v.getItemInRoom();
                NPC npc = v.getNpcInRoom();
                Furniture furniture = v.getFurnitureInRoom();

                if (v.isHasItem() && Item.class.equals(item.getClass())) {
                    itemChar = "I";
                    for (Map.Entry<Integer, Item> entry : player.getAllObjects().allItems.items.entrySet()) {
                        if (Objects.equals(item.getName(), entry.getValue().getName())) {
                            itemNum = entry.getKey().toString();
                        }
                    }

                } else if (v.isHasItem() && Consumable.class.equals(item.getClass())) {
                    itemChar = "C";
                    for (Map.Entry<Integer, Consumable> entry : player.getAllObjects().allItems.consumables.entrySet()) {
                        if (Objects.equals(item.getName(), entry.getValue().getName())) {
                            itemNum = entry.getKey().toString();
                        }
                    }
                } else if (v.isHasItem() && Weapon.class.equals(item.getClass())) {
                    itemChar = "W";
                    for (Map.Entry<Integer, Weapon> entry : player.getAllObjects().allItems.weapons.entrySet()) {
                        if (Objects.equals(item.getName(), entry.getValue().getName())) {
                            itemNum = entry.getKey().toString();
                        }
                    }
                } else if (v.isHasItem() && Armor.class.equals(item.getClass())) {
                    itemChar = "A";
                    for (Map.Entry<Integer, Armor> entry : player.getAllObjects().allItems.armors.entrySet()) {
                        if (Objects.equals(item.getName(), entry.getValue().getName())) {
                            itemNum = entry.getKey().toString();
                        }
                    }
                }

                if (v.isHasNPC() && NPC.class.equals(npc.getClass())) {
                    npcChar = "N";
                    for (Map.Entry<Integer, NPC> entry : player.getAllObjects().npcs.entrySet()) {
                        if (Objects.equals(npc.getName(), entry.getValue().getName())) {
                            npcNum = entry.getKey().toString();
                        }
                    }
                }

                if (v.isHasFurniture() && Furniture.class.equals(furniture.getClass())) {
                    furnitureChar = "F";
                    for (Map.Entry<Integer, Furniture> entry : player.getAllObjects().furnitures.entrySet()) {
                        if (Objects.equals(furniture.getName(), entry.getValue().getName())) {
                            furnitureNum = entry.getKey().toString();
                        }
                    }

                } else if (v.isHasFurniture() && Container.class.equals(furniture.getClass())) {
                    furnitureChar = "C";
                    for (Map.Entry<Integer, Container> entry : player.getAllObjects().containers.entrySet()) {
                        if (Objects.equals(furniture.getName(), entry.getValue().getName())) {
                            furnitureNum = entry.getKey().toString();
                        }
                    }
                }

                roomWrite.write(
                        MessageFormat.format(
                                "\n{0}:{1}:{2}:{3}:{4}:{5}:{6}:{7}:{8}:{9}:{10}:",
                                k.toString(), v.getName(),
                                v.isHasItem(), itemChar, itemNum,
                                v.isHasNPC(), npcChar, npcNum,
                                v.isHasFurniture(), furnitureChar, furnitureNum
                        ));
            }
            roomWrite.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to save file. " + e);
        }
    }

    public static void saveContainersInRoomInventory(Player player) {
        final String saveRoomFilePath = "src/dev/tesch/save/furniture/containerInventory.txt";

        try {
            FileWriter inventoryWrite = new FileWriter(saveRoomFilePath);

            for (Map.Entry<Integer, Room> e : player.getRooms().entrySet()) {
                Integer k = e.getKey();
                Room v = e.getValue();

                String itemChar = "NA", itemNum = null;

                if (v.isHasFurniture() && Container.class.equals(v.getFurnitureInRoom().getClass())) {
                    Container container = (Container) v.getFurnitureInRoom();

                    List<Item> containerInventory = container.getContainerInventory();

                    inventoryWrite.write("\nR" + ";" + k.toString() + ":");

                    for (Item item: containerInventory) {

                        if (Item.class.equals(item.getClass())) {
                            itemChar = "I";
                            for (Map.Entry<Integer, Item> entry : player.getAllObjects().allItems.items.entrySet()) {
                                if (Objects.equals(item.getName(), entry.getValue().getName())) {
                                    itemNum = entry.getKey().toString();
                                }
                            }

                        } else if (Consumable.class.equals(item.getClass())) {
                            itemChar = "C";
                            for (Map.Entry<Integer, Consumable> entry : player.getAllObjects().allItems.consumables.entrySet()) {
                                if (Objects.equals(item.getName(), entry.getValue().getName())) {
                                    itemNum = entry.getKey().toString();
                                }
                            }
                        } else if (Weapon.class.equals(item.getClass())) {
                            itemChar = "W";
                            for (Map.Entry<Integer, Weapon> entry : player.getAllObjects().allItems.weapons.entrySet()) {
                                if (Objects.equals(item.getName(), entry.getValue().getName())) {
                                    itemNum = entry.getKey().toString();
                                }
                            }
                        } else if (Armor.class.equals(item.getClass())) {
                            itemChar = "A";
                            for (Map.Entry<Integer, Armor> entry : player.getAllObjects().allItems.armors.entrySet()) {
                                if (Objects.equals(item.getName(), entry.getValue().getName())) {
                                    itemNum = entry.getKey().toString();
                                }
                            }
                        }

                        inventoryWrite.write(itemChar + ";" + itemNum + ":");
                    }
                    inventoryWrite.write("-");
                }
            }
            inventoryWrite.close();
        }
        catch (IOException e) {
            System.out.println("An error occurred while writing to save file. " + e);
        }
    }
}
