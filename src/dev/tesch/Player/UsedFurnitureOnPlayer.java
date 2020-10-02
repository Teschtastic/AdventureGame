package dev.tesch.Player;

import dev.tesch.Furniture.Furniture;

public class UsedFurnitureOnPlayer {

    public static void useFurniture(Player player, Furniture furniture) {
        switch (furniture.getName()) {
            case "Camping chair":
                usedCampingChair(player);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedCampingChair(Player player) {
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }
}
