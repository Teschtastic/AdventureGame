package dev.tesch.Player;

import dev.tesch.Items.Item;

import java.util.List;

public class Player {

    public Player(String n, Integer h, Integer aDamage, List<Item> inv) {
        setName(n);
        setHealth(h);
        setAttackDamage(aDamage);
        setInventory(inv);
    }

    private String name;
    private Integer health;
    private Integer attackDamage;
    private List<Item> inventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getAttackDamage() {
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
