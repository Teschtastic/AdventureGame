package dev.tesch.Player;

import dev.tesch.Crafting.Recipe;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Armors;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.Items.Weapons;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;

public class Player {

    // HashMaps
    public Map<Integer, Room>       rooms = new Rooms().roomsMap;
    public Map<Integer, Armor>      armors = new Armors().armorMap;
    public Map<Integer, Weapon>     weapons = new Weapons().weaponMap;

    // Constructing the player object
    public Player() {
        setInventory(new LinkedList<>());
    }

    private String name;                // Player name
    private int currentHealth;          // Player current health
    private int maximumHealth;          // PLayer max health
    private int armorClass;             // Player armor
    private int attackDamage;           // Player attack damage
    private List<Item> inventory;       // Player inventory
    private Room roomIsIn;              // Room object the player is in
    private Armor equippedArmor;        // Armor object equipped to the player
    private boolean hasEquippedArmor;   // Flag for if armor is equipped
    private Weapon equippedWeapon;      // Weapon object equipped to the player
    private boolean hasEquippedWeapon;  // Flag for if a weapon is equipped
    private List<Recipe> knownRecipes;  // List of known recipes
    private int currentCarryWeight;  // Value for current carry weight
    private int maximumCarryWeight;  // Value for maximum carry weight
    private String choice;              // Value for player choice

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
        for (Item i : new LinkedList<>(items)) {
            this.inventory.remove(i);
            this.currentCarryWeight -= i.getItemWeight();
        }
    }

    public Integer getRoomIndex() {
        for (Entry<Integer, Room> entry : rooms.entrySet()) {
            if (Objects.equals(roomIsIn, entry.getValue())) {
                return entry.getKey();
            }
        }
        return 1;
    }

    public Room getRoomIsIn() {
        return roomIsIn;
    }

    public void setRoomIsIn(Room roomIsIn) {
        this.roomIsIn = roomIsIn;
    }
    
    public void setRoomIsIn(int roomIsInIndex) {
        this.roomIsIn = rooms.get(roomIsInIndex);
    }

    public String getChoice() {
        return choice;
    }

    public void setChoice(String choice) {
        this.choice = choice;
    }

    public Integer getArmorIndex() {
        for (Entry<Integer, Armor> entry : armors.entrySet()) {
            if (Objects.equals(equippedArmor, entry.getValue())) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public Armor getEquippedArmor() {
        return equippedArmor;
    }

    public void setEquippedArmor(Armor equippedArmor) {
        this.equippedArmor = equippedArmor;
    }

    public void setEquippedArmor(int equippedArmorIndex) {
        this.equippedArmor = armors.get(equippedArmorIndex);
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

    public Integer getWeaponIndex() {
        for (Entry<Integer, Weapon> entry : weapons.entrySet()) {
            if (Objects.equals(equippedWeapon, entry.getValue())) {
                return entry.getKey();
            }
        }
        return 0;
    }

    public Weapon getEquippedWeapon() {
        return equippedWeapon;
    }

    public void setEquippedWeapon(Weapon equippedWeapon) {
        this.equippedWeapon = equippedWeapon;
    }
    
    public void setEquippedWeapon(int equippedWeaponIndex) {
        this.equippedWeapon = weapons.get(equippedWeaponIndex);
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

    public void addToRecipes(Recipe recipe) {
        this.knownRecipes.add(recipe);
    }

    public void addToRecipes(List<Recipe> recipe) {
        this.knownRecipes.addAll(recipe);
    }

    public int getCurrentCarryWeight() {
        return currentCarryWeight;
    }

    public void setCurrentCarryWeight(int currentCarryWeight) {
        this.currentCarryWeight = currentCarryWeight;
    }

    public int getMaximumCarryWeight() {
        return maximumCarryWeight;
    }

    public void setMaximumCarryWeight(int maximumCarryWeight) {
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
