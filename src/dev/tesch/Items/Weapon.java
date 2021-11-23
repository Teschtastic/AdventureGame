package dev.tesch.Items;

public class Weapon extends Item {

    public Weapon(
            String n,
            String d,
            String uMessage,
            int itW,
            boolean cPickup,
            boolean cUse,
            boolean cC,
            boolean iA,
            boolean iW,
            int aD) {
        super(n, d, uMessage, itW, cPickup, cUse, cC, iA, iW);
        setAttackDamage(aD);
    }

    private int attackDamage;

    public int getAttackDamage() {
        return attackDamage;
    }

    public void setAttackDamage(int attackDamage) {
        this.attackDamage = attackDamage;
    }

    @Override
    public boolean equals(Object obj) {
        final Weapon weapon = (Weapon) obj;
        return weapon.getName().equals(this.getName());
    }
}
