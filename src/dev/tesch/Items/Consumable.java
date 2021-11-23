package dev.tesch.Items;

public class Consumable extends Item {

    public Consumable(
            String n,
            String d,
            String uMessage,
            int itW,
            boolean cPickup,
            boolean cUse,
            boolean cC,
            boolean iA,
            boolean iW,
            int sM) {
        super(n, d, uMessage, itW, cPickup, cUse, cC, iA, iW);
        setStatusModifier(sM);
    }

    private int statusModifier;

    public int getStatusModifier() {
        return statusModifier;
    }

    public void setStatusModifier(int statusModifier) {
        this.statusModifier = statusModifier;
    }

    @Override
    public boolean equals(Object obj) {
        final Consumable consumable = (Consumable) obj;
        return consumable.getName().equals(this.getName());
    }
}
