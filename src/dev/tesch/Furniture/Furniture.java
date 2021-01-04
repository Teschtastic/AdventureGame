package dev.tesch.Furniture;

public class Furniture {

    public Furniture(String n, String d, String uMessage, int fIndex, int rL, boolean cUse) {
        setName(n);
        setDescription(d);
        setUseMessage(uMessage);
        setFurnitureIndex(fIndex);
        setRoomLocation(rL);
        setCanUse(cUse);
    }

    private String name;
    private String description;
    private String useMessage;
    private int furnitureIndex;
    private int roomLocation;
    private boolean canUse;

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

    public String getUseMessage() {
        return useMessage;
    }

    public void setUseMessage(String useMessage) {
        this.useMessage = useMessage;
    }

    public int getFurnitureIndex() {
        return furnitureIndex;
    }

    public void setFurnitureIndex(int furnitureIndex) {
        this.furnitureIndex = furnitureIndex;
    }

    public int getRoomLocation() {
        return roomLocation;
    }

    public void setRoomLocation(int roomLocation) {
        this.roomLocation = roomLocation;
    }

    public boolean isCanUse() {
        return canUse;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
    }
}
