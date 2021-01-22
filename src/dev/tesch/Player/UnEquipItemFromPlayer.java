package dev.tesch.Player;

import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;

import java.util.List;

public class UnEquipItemFromPlayer {
    public static void unEquipArmor(Player player, Armor armor) {
        List<Item> inventory = player.getInventory();

        System.out.println("\nYou un equip your " + armor.getName());
        System.out.println("Your armor class decreases by " + armor.getArmorClass() + ".");
        player.setEquippedArmor(null);
        player.setHasEquippedArmor(false);
        player.setArmorClass(player.getArmorClass() - armor.getArmorClass());
        inventory.add(armor);
    }

    public static void unEquipWeapon(Player player, Weapon weapon) {
        List<Item> inventory = player.getInventory();

        System.out.println("\nYou un equip your " + weapon.getName());
        System.out.println("Your attack damage decreases by " + weapon.getAttackDamage() + ".");
        player.setEquippedWeapon(null);
        player.setHasEquippedWeapon(false);
        player.setAttackDamage(player.getAttackDamage() - weapon.getAttackDamage());
        inventory.add(weapon);
    }
}
