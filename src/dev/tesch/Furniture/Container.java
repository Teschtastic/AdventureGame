package dev.tesch.Furniture;

import dev.tesch.Items.Item;

import java.util.LinkedList;
import java.util.List;

public class Container extends Furniture {

    public Container(String n, String d, String uMessage, boolean cUse, List<Item> cInventory) {
        super(n, d, uMessage, cUse);
        setContainerInventory(cInventory);
    }

    private List<Item> containerInventory;

    public List<Item> getContainerInventory() {
        return containerInventory;
    }

    public void setContainerInventory(List<Item> containerInventory) {
        this.containerInventory = containerInventory;
    }

    public void addToInventory(Item item) {
        this.containerInventory.add(item);
    }

    public void addToInventory(List<Item> items) {
        for (Item i: items) {
            this.containerInventory.add(i);
        }
    }

    public void removeFromInventory(Item item) {
        this.containerInventory.remove(item);
    }

    public void removeFromInventory(List<Item> items) {
        for (Item i : new LinkedList<>(items)) {
            this.containerInventory.remove(i);
        }
    }
}
