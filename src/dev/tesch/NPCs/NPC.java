package dev.tesch.NPCs;

import dev.tesch.Items.*;

// Placeholder for adding NPCs to the game
public class NPC {

    public NPC(String n, String m, int h, boolean isF, boolean hasI, Item iInInv) {
        setName(n);
        setMessage(m);
        setHealth(h);
        setFriendly(isF);
        setHasItem(hasI);
        setItemInInventory(iInInv);
    }

    private String name;
    private String message;
    private int health;
    private boolean isFriendly;
    private boolean hasItem;
    private Item itemInInventory;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isFriendly() {
        return isFriendly;
    }

    public void setFriendly(boolean friendly) {
        isFriendly = friendly;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public Item getItemInInventory() {
        return itemInInventory;
    }

    public void setItemInInventory(Item itemInInventory) {
        this.itemInInventory = itemInInventory;
    }
}
