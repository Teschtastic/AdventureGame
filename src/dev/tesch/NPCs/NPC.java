package dev.tesch.NPCs;

import dev.tesch.Items.*;

import java.util.Map;

// Placeholder for adding NPCs to the game
public class NPC {

    public NPC(String n, String m, int npcI, int h, boolean isF, boolean hasI, int iInInvInd, Item iInInv) {
        setName(n);
        setMessage(m);
        setNpcIndex(npcI);
        setHealth(h);
        setFriendly(isF);
        setHasItem(hasI);
        setItemInInventoryIndex(iInInvInd);
        setItemInInventory(iInInv);
    }

    private String name;
    private String message;
    private int npcIndex;
    private int health;
    private boolean isFriendly;
    private boolean hasItem;
    private int itemInInventoryIndex;
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

    public int getNpcIndex() {
        return npcIndex;
    }

    public void setNpcIndex(int npcIndex) {
        this.npcIndex = npcIndex;
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

    public int getItemInInventoryIndex() {
        return itemInInventoryIndex;
    }

    public void setItemInInventoryIndex(int itemInInventoryIndex) {
        this.itemInInventoryIndex = itemInInventoryIndex;
    }

    public Item getItemInInventory() {
        return itemInInventory;
    }

    public void setItemInInventory(Item itemInInventory) {
        this.itemInInventory = itemInInventory;
    }
}
