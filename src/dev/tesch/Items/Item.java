package dev.tesch.Items;

// Placeholder for adding items to the game later
public class Item {

    public Item(String n, String d, String uMessage, int iIndex, boolean cPickup, boolean cUse, boolean cC, boolean iA, boolean iW) {
        setName(n);
        setDescription(d);
        setUseMessage(uMessage);
        setItemIndex(iIndex);
        setCanPickup(cPickup);
        setCanUse(cUse);
        setCanCraft(cC);
        setArmor(iA);
        setWeapon(iW);
    }

    private String name;
    private String description;
    private String useMessage;
    private int itemIndex;
    private boolean canPickup;
    private boolean canUse;
    private boolean canCraft;
    private boolean isArmor;
    private boolean isWeapon;

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

    public String getUseMessage() {
        return useMessage;
    }

    public void setUseMessage(String useMessage) {
        this.useMessage = useMessage;
    }

    public void setItemIndex(int itemIndex) {
        this.itemIndex = itemIndex;
    }

    public boolean getCanPickup() {
        return canPickup;
    }

    public void setCanPickup(Boolean canPickup) {
        this.canPickup = canPickup;
    }

    public boolean isCanUse() {
        return canUse;
    }

    public void setCanUse(boolean canUse) {
        this.canUse = canUse;
    }

    public boolean isCanCraft() {
        return canCraft;
    }

    public void setCanCraft(boolean canCraft) {
        this.canCraft = canCraft;
    }

    public boolean isArmor() {
        return isArmor;
    }

    public void setArmor(boolean armor) {
        isArmor = armor;
    }

    public boolean isWeapon() {
        return isWeapon;
    }

    public void setWeapon(boolean weapon) {
        isWeapon = weapon;
    }

    @Override
    public boolean equals(Object obj) {
        final Item item = (Item) obj;
        if (item.getName().equals(this.name) && item.getItemIndex() == this.itemIndex)
            return true;
        return false;
    }
}
