package dev.tesch.Items;

public class Armor extends Item {

    public Armor(String n, String d, String uMessage, int aIndex, int rL, boolean cPickup, boolean cUse, boolean cC, boolean iA, int aC) {
        super(n, d, uMessage, aIndex, rL, cPickup, cUse, iA, cC);
        setArmorClass(aC);
    }

    private int armorClass;
    private boolean canEquip;

    public int getArmorClass() {
        return armorClass;
    }

    public void setArmorClass(int armorClass) {
        this.armorClass = armorClass;
    }
}
