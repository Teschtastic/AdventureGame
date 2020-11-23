package dev.tesch.Player;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;

import java.util.List;

public class EquipItemToPlayer {
    public static void equipArmor(Player player, Armor armor) {
        switch (armor.getName()) {

            case "Cardboard Armor":
                usedCardboardArmor(player, armor);
                break;

            default:
                System.out.println("\nThis doesn't seem to be\nable to be equipped");
        }
    }

    public static void equipWeapon(Player player, Weapon weapon) {
        switch (weapon.getName()) {

            case "Stabby Thingies":
                useStabbyThingies(player, weapon);
                break;

            default:
                System.out.println("\nThis doesn't seem to be\nable to be equipped");
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

    private static void useStabbyThingies(Player player, Weapon weapon) {
        List<Item> inventory = player.getInventory();

        System.out.println(weapon.getUseMessage());
        System.out.println("\nYour attack damage increased by " + weapon.getAttackDamage() + ".");
        player.setEquippedWeapon(weapon);
        player.setArmorClass(player.getArmorClass() + weapon.getAttackDamage());
        inventory.remove(weapon);
    }
}
