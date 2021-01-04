package dev.tesch.Items;

public class Weapon extends Item {

    public Weapon(String n, String d, String uMessage, int wIndex, int rL, boolean cPickup, boolean cUse, boolean cC, boolean iA, boolean iW, int aD) {
        super(n, d, uMessage, wIndex, rL, cPickup, cUse, cC, iA, iW);
        setAttackDamage(aD);
    }

    private int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }
}
