package dev.tesch.Player;

import dev.tesch.Crafting.Recipe;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.List;
import java.util.Map;

public class Player {

    // HashMap the rooms are stored in
    public Map<Integer, Room> rooms = new Rooms().roomsMap;

    // Constructing the player object
    public Player(String n,
                  int cH,
                  int mH,
                  int aC,
                  int aDamage,
                  double cCW,
                  double mCW,
                  List<Item> inv,
                  boolean hEA,
                  boolean hEW,
                  List<Recipe> r,
                  int room) {

        setName(n);
        setCurrentHealth(cH);
        setMaximumHealth(mH);
        setArmorClass(aC);
        setAttackDamage(aDamage);
        setCurrentCarryWeight(cCW);
        setMaximumCarryWeight(mCW);
        setInventory(inv);
        setHasEquippedArmor(hEA);
        setHasEquippedWeapon(hEW);
        setKnownRecipes(r);
        setRoomIsIn(rooms.get(room));
    }

    private String name;            // Player name
    private int currentHealth;      // Player current health
    private int maximumHealth;      // PLayer max health
    private int armorClass;         // Player armor
    private int attackDamage;       // Player attack damage
    private List<Item> inventory;   // Player inventory
    private Room roomIsIn;
    private Armor equippedArmor;
    private boolean hasEquippedArmor;
    private Weapon equippedWeapon;
    private boolean hasEquippedWeapon;
    private List<Recipe> knownRecipes;
    private double currentCarryWeight;
    private double maximumCarryWeight;
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
        this.currentCarryWeight += item.getItemWeight();
    }

    public void addToInventory(List<Item> items) {
        for (Item i: items) {
            this.inventory.add(i);
            this.currentCarryWeight += i.getItemWeight();
        }
    }

    public void removeFromInventory(Item item) {
        this.inventory.remove(item);
        this.currentCarryWeight -= item.getItemWeight();
    }

    public void removeFromInventory(List<Item> items) {
        for (Item i: items) {
            this.inventory.remove(i);
            this.currentCarryWeight -= i.getItemWeight();
        }
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

    public String printWeapon() {
        if (getEquippedWeapon() == null)
            return "Fists";
        else
            return getEquippedWeapon().getName();
    }

    public List<Recipe> getKnownRecipes() {
        return knownRecipes;
    }

    public void setKnownRecipes(List<Recipe> knownRecipes) {
        this.knownRecipes = knownRecipes;
    }

    public double getCurrentCarryWeight() {
        return currentCarryWeight;
    }

    public void setCurrentCarryWeight(double currentCarryWeight) {
        this.currentCarryWeight = currentCarryWeight;
    }

    public double getMaximumCarryWeight() {
        return maximumCarryWeight;
    }

    public void setMaximumCarryWeight(double maximumCarryWeight) {
        this.maximumCarryWeight = maximumCarryWeight;
    }

    @Override
    public String toString() {
        return  "\nPlayer Description:\n\n" +
                "Name:            " + getName()                 + "\n" +
                "Current health:  " + getCurrentHealth()        + "\n" +
                "Maximum health:  " + getMaximumHealth()        + "\n" +
                "Current weight:  " + getCurrentCarryWeight()   + "\n" +
                "Maximum weight:  " + getMaximumCarryWeight()   + "\n" +
                "Armor class:     " + getArmorClass()           + "\n" +
                "Attack damage:   " + getAttackDamage()         + "\n" +
                "Equipped armor:  " + printArmor()              + "\n" +
                "Equipped weapon: " + printWeapon();
    }
}
