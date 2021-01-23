package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedFurnitureOnPlayer;

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

    /* Method used to describe a furniture */
    public static void describeFurniture(Player player) {

        try {
            Furniture furniture = player.getRoomIsIn().getFurnitureInRoom();

            System.out.println("\nYou inspect the " + furniture.getName() +
                    "\n\nYou describe it as:\n" + furniture.getDescription());
        }
        catch (NullPointerException e) {
            System.out.println("\nThere isn't any furniture in this room.");
        }
    }
}
