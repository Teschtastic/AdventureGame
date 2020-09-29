package dev.tesch.Player;

import dev.tesch.Items.Item;

public class UsedItemsOnPlayer {

    public static void useItem(Player player, Item item) {
        switch (item.getName()) {
            case "Dr. Pepper":
                usedDrPepper(player);
                break;

            case "Cardboard boxes":
                usedBoxes(player);
                break;

            case "Camping chair":
                usedCampingChair(player);
                break;

            default:
                System.out.println("\nThis item doesn't seem to help you");
        }
    }

    private static void usedDrPepper(Player player) {
        System.out.println("\nYour attack damage increased by 10.");
        player.setAttackDamage(player.getAttackDamage() + 10);
    }

    private static void usedBoxes(Player player) {
        System.out.println("\nYour armor class increased by 25.");
        player.setArmorClass(player.getArmorClass() + 25);
    }

    private static void usedCampingChair(Player player) {
        System.out.println("\nYour health has been restored.");
        player.setCurrentHealth(player.getMaximumHealth());
    }
}
