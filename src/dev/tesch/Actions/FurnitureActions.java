package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedFurnitureOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class FurnitureActions {

    /* Method used to use a furniture */
    public static void useFurniture(Player player, Map<Integer, Room> userRooms, Map<Integer, NPC> userNPCs, Map<Integer, Item> userItems, Map<Integer, Armor> userArmors, Map<Integer, Weapon> userWeapons, Map<Integer, Furniture> userFurnitures) {
        Room room = userRooms.get(player.getRoomIsIn());
        Furniture furniture = userFurnitures.get(room.getFurnitureInRoom());

        if (room.isHasFurniture()) {
            if (furniture.isCanUse()) {
                System.out.println(furniture.getUseMessage());
                UsedFurnitureOnPlayer.useFurniture(player, furniture, userRooms, userItems, userArmors, userWeapons, userNPCs);
            } else
                System.out.println("\nYou can't use this furniture");
        }
        else {
            System.out.println("\nThere isn't furniture in this room");
        }
    }
}
