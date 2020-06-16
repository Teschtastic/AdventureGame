package dev.tesch.Items;

// Placeholder for adding items to the game later
public class Item {

    public Item(String n, String d, int iIndex, int rL, boolean cPickup) {
        setName(n);
        setDescription(d);
        setItemIndex(iIndex);
        setRoomLocation(rL);
        setCanPickup(cPickup);
    }

    private String name;
    private String description;
    private int itemIndex;
    private int roomLocation;
    private boolean canPickup;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getItemIndex() {
        return itemIndex;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public int getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(Integer roomLocation) {
        this.roomLocation = roomLocation;
    }

    public boolean getCanPickup() {
        return canPickup;
    }

    public void setCanPickup(Boolean canPickup) {
        this.canPickup = canPickup;
    }
}
