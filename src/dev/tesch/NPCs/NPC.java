package dev.tesch.NPCs;

// Placeholder for adding NPCs to the game
public class NPC {

    public NPC(String n, String m, int npcI, int h, boolean isF, int rIsIn, boolean hasI, int iInInv) {
        setName(n);
        setMessage(m);
        setNpcIndex(npcI);
        setHealth(h);
        setFriendly(isF);
        setRoomIsIn(rIsIn);
        setHasItem(hasI);
        setItemInInventory(iInInv);
    }

    private String name;
    private String message;
    private int npcIndex;
    private int health;
    private boolean isFriendly;
    private int roomIsIn;
    private boolean hasItem;
    private int itemInInventory;

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

    public int getRoomIsIn() {
        return roomIsIn;
    }

    public void setRoomIsIn(int roomIsIn) {
        this.roomIsIn = roomIsIn;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public int getItemInInventory() {
        return itemInInventory;
    }

    public void setItemInInventory(int itemInInventory) {
        this.itemInInventory = itemInInventory;
    }
}
