package dev.tesch.Player;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;

import java.util.List;

public class EquipItemToPlayer {
    public static void equipArmor(Player player, Armor armor) {
        switch (armor.getName()) {

            case "Cardboard Armor":
                usedCardboardArmor(player, armor);
                break;

            default:
                System.out.println("\nThis doesn't seem to help you");
        }
    }

    private static void usedCardboardArmor(Player player, Armor armor) {
        List<Item> inventory = player.getInventory();

        System.out.println(armor.getUseMessage());
        System.out.println("\nYour armor class increased by " + armor.getArmorClass() + ".");
        player.setEquippedArmor(armor);
        player.setArmorClass(player.getArmorClass() + armor.getArmorClass());
        inventory.remove(armor);
    }
}
