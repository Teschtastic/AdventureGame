package dev.tesch.Player;

import dev.tesch.Items.Consumable;
import dev.tesch.Items.Consumables;
import dev.tesch.Items.Item;

import java.util.List;

public class UsedItemOnPlayer {

    public static void useItem(Player player, Item item) {
        switch (item.getName()) {
            case "Dr. Pepper":
                usedDrPepper(player, (Consumable) item);
                break;

            case "Desktop PC":
                usedPC(player, item);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedDrPepper(Player player, Consumable item) {
        System.out.println("\nYour carry weight increased by " + item.getStatusModifier() + ".");
        player.setMaximumCarryWeight(player.getMaximumCarryWeight() + item.getStatusModifier());
        player.removeFromInventory(item);
    }

    private static void usedPC(Player player, Item item) {
        System.out.println(
                "\nYou look up fighting techniques\non the internet." +
                "\nYour attack damage goes up by 10.");

        player.setAttackDamage(player.getAttackDamage() + 10);
        item.setCanUse(false);
    }
}
