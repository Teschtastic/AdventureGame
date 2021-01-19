package dev.tesch.Furniture;

import dev.tesch.Items.Item;

import java.util.List;

public class Container extends Furniture {

    public Container(String n, String d, String uMessage, int cIndex, int rL, boolean cUse, List<Item> cInventory) {
        super(n, d, uMessage, cIndex, rL, cUse);
        setContainerInventory(cInventory);
    }

    private List<Item> containerInventory;

    public List<Item> getContainerInventory() {
        return containerInventory;
    }

    public void setContainerInventory(List<Item> containerInventory) {
        this.containerInventory = containerInventory;
    }
}
