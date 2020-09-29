package dev.tesch.Player;

import dev.tesch.Items.Item;

import java.util.List;

public class Player {

    // Constructing the player object
    public Player(String n, int cH, int mH, int aC, int aDamage, List<Item> inv, int rIsIn) {
        setName(n);
        setCurrentHealth(cH);
        setMaximumHealth(mH);
        setArmorClass(aC);
        setAttackDamage(aDamage);
        setInventory(inv);
        setRoomIsIn(rIsIn);
    }

    private String name;            // Player name
    private int currentHealth;      // Player current health
    private int maximumHealth;      // PLayer max health
    private int armorClass;         // Player armor
    private int attackDamage;       // Player attack damage
    private List<Item> inventory;   // Player inventory
    private int roomIsIn;
    private String choice;

    /* Getters and setters */
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public int getMaximumHealth() {
        return maximumHealth;
    }

    public void setMaximumHealth(int maximumHealth) {
        this.maximumHealth = maximumHealth;
    }

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
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

    public int getRoomIsIn() {
        return roomIsIn;
    }

    public void setRoomIsIn(int roomIsIn) {
        this.roomIsIn = roomIsIn;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    @Override
    public String toString() {
        return  "\nPlayer Description:\n\n" +
                "name="                     + name          + "\n" +
                "currentHealth="            + currentHealth + "\n" +
                "maximumHealth="            + maximumHealth + "\n" +
                "armorClass="               + armorClass    + "\n" +
                "attackDamage="             + attackDamage;
    }
}
