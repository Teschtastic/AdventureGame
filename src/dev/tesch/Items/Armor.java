package dev.tesch.Items;

public class Armor extends Item {

    public Armor(String n, String d, String uMessage, boolean cPickup, boolean cUse, boolean cC, boolean iA, boolean iW, int aC) {
        super(n, d, uMessage, cPickup, cUse, cC, iA, iW);
        setArmorClass(aC);
    }

    private int armorClass;

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}
