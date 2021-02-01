package dev.tesch.Crafting;

import dev.tesch.Items.Item;

import java.util.List;

public class Recipe {

    public Recipe(List<Item> craftingItems, Item craftedItem) {
        setInputItems(craftingItems);
        setOutputItem(craftedItem);
    }

    private List<Item> inputItems;
    private Item outputItem;

    public boolean canCraft(List<Item> inventory) {
        return inventory.containsAll(getInputItems());
    }

    public List<Item> getInputItems() {
        return inputItems;
    }

    public void setInputItems(List<Item> inputItems) {
        this.inputItems = inputItems;
    }

    public Item getOutputItem() {
        return outputItem;
    }

    public void setOutputItem(Item outputItems) {
        this.outputItem = outputItems;
    }
}

