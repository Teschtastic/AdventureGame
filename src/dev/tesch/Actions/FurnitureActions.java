package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedFurnitureOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class FurnitureActions {

    /* Method used to use a furniture */
    public static void useFurniture(
            Player player,
            Map<Integer, Room> userRooms,
            Map<Integer, Item> userItems,
            Map<Integer, Armor> userArmors,
            Map<Integer, Weapon> userWeapons) {

        Room room = userRooms.get(player.getRoomIsInIndex());

        if (room.isHasFurniture()) {
            Furniture furniture = room.getFurnitureInRoom();

            if (furniture.isCanUse()) {
                System.out.println(furniture.getUseMessage());
                UsedFurnitureOnPlayer.useFurniture(player, furniture, room, userItems, userArmors, userWeapons);
            } else
                System.out.println("\nYou can't use this furniture");
        }
        else {
            System.out.println("\nThere isn't furniture in this room");
        }
    }
}
