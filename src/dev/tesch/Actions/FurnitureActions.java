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
    public static void useFurniture(Player player) {

        if (player.getRoomIsIn().isHasFurniture()) {
            Furniture furniture = player.getRoomIsIn().getFurnitureInRoom();

            if (furniture.isCanUse()) {
                System.out.println(furniture.getUseMessage());
                UsedFurnitureOnPlayer.useFurniture(player);
            } else
                System.out.println("\nYou can't use this furniture");
        }
        else {
            System.out.println("\nThere isn't furniture in this room");
        }
    }
}
