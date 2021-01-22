package dev.tesch.Player;

import dev.tesch.Crafting.Recipe;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Rooms.Room;

import java.util.List;

public class Player {

    // Constructing the player object
    public Player(String n,
                  int cH,
                  int mH,
                  int aC,
                  int aDamage,
                  List<Item> inv,
                  int rIIIndex,
                  boolean hEA,
                  boolean hEW,
                  List<Recipe> r) {

        setName(n);
        setCurrentHealth(cH);
        setMaximumHealth(mH);
        setArmorClass(aC);
        setAttackDamage(aDamage);
        setInventory(inv);
        setRoomIsInIndex(rIIIndex);
        setHasEquippedArmor(hEA);
        setHasEquippedWeapon(hEW);
        setKnownRecipes(r);
    }

    private String name;            // Player name
    private int currentHealth;      // Player current health
    private int maximumHealth;      // PLayer max health
    private int armorClass;         // Player armor
    private int attackDamage;       // Player attack damage
    private List<Item> inventory;   // Player inventory
    private int roomIsInIndex;
    private Room roomIsIn;
    private Armor equippedArmor;
    private boolean hasEquippedArmor;
    private Weapon equippedWeapon;
    private boolean hasEquippedWeapon;
    private List<Recipe> knownRecipes;
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

    public int getRoomIsInIndex() {
        return roomIsInIndex;
    }

    public void setRoomIsInIndex(int roomIsInIndex) {
        this.roomIsInIndex = roomIsInIndex;
    }

    public Room getRoomIsIn() {
        return roomIsIn;
    }

    public void setRoomIsIn(Room roomIsIn) {
        this.roomIsIn = roomIsIn;
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public boolean isHasEquippedArmor() {
        return hasEquippedArmor;
    }

    public void setHasEquippedArmor(boolean hasEquippedArmor) {
        this.hasEquippedArmor = hasEquippedArmor;
    }

    public String printArmor() {
        if (getEquippedArmor() == null)
            return "None";
        else
            return getEquippedArmor().getName();
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }

    public boolean isHasEquippedWeapon() {
        return hasEquippedWeapon;
    }

    public void setHasEquippedWeapon(boolean hasEquippedWeapon) {
        this.hasEquippedWeapon = hasEquippedWeapon;
    }

    public List<Recipe> getKnownRecipes() {
        return knownRecipes;
    }

    public void setKnownRecipes(List<Recipe> knownRecipes) {
        this.knownRecipes = knownRecipes;
    }

    public String printWeapon() {
        if (getEquippedWeapon() == null)
            return "Fists";
        else
            return getEquippedWeapon().getName();
    }

    @Override
    public String toString() {
        return  "\nPlayer Description:\n\n" +
                "Name:            " + getName()          + "\n" +
                "Current health:  " + getCurrentHealth() + "\n" +
                "Maximum health:  " + getMaximumHealth() + "\n" +
                "Armor class:     " + getArmorClass()    + "\n" +
                "Attack damage:   " + getAttackDamage()  + "\n" +
                "Equipped armor:  " + printArmor()       + "\n" +
                "Equipped weapon: " + printWeapon();
    }
}
