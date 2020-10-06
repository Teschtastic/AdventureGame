package dev.tesch.Player;

import dev.tesch.Items.Item;

import java.util.List;

public class UsedItemOnPlayer {

    public static void useItem(Player player, Item item) {
        switch (item.getName()) {
            case "Dr. Pepper":
                usedDrPepper(player, item);
                break;

            case "Cardboard Armor":
                usedCardboardArmor(player, item);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedDrPepper(Player player, Item item) {
        List<Item> inventory = player.getInventory();

        System.out.println("\nYour attack damage increased by 10.");
        player.setAttackDamage(player.getAttackDamage() + 10);
        inventory.remove(item);
    }

    private static void usedCardboardArmor(Player player, Item item) {
        List<Item> inventory = player.getInventory();

        System.out.println("\nYour armor class increased by 25.");
        player.setArmorClass(player.getArmorClass() + 25);
        inventory.remove(item);
    }
}
