package dev.tesch.Player;

import dev.tesch.Items.Item;

import java.util.List;

public class Player {

    // Constructing the player object
    public Player(String n, int h, int aDamage, List<Item> inv) {
        setName(n);
        setHealth(h);
        setAttackDamage(aDamage);
        setInventory(inv);
    }

    private String name;            // Player name
    private int health;         // Player health
    private int attackDamage;   // Player attack damage
    private List<Item> inventory;   // Player inventory

    /* Getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(Integer attackDamage) {
        this.attackDamage = attackDamage;
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public void setInventory(List<Item> inventory) {
        this.inventory = inventory;
    }

    public void addToInventory(Item item) {
        this.inventory.add(item);
    }
}
