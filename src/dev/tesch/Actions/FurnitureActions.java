package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Player.Player;
import dev.tesch.Player.UsedFurnitureOnPlayer;
import dev.tesch.Rooms.Room;

import java.util.Map;

public class FurnitureActions {

    /* Method used to use a furniture */
    public static void useFurniture(Player player, Map<Integer, Room> userRooms, Map<Integer, Furniture> userFurnitures) {
        Room room = userRooms.get(player.getRoomIsIn());
        Furniture furniture = userFurnitures.get(room.getFurnitureInRoom());

        if (furniture.isCanUse()) {
            System.out.println(furniture.getUseMessage());
            UsedFurnitureOnPlayer.useFurniture(player, furniture);
        }
        else
            System.out.println("\nYou can't use this furniture");
    }
}
