package dev.tesch.Items;

import java.util.HashMap;

public class Consumables {

    public HashMap<Integer, Consumable> consumablesMap = new HashMap<>();

    public Consumables() {
        consumablesMap.put(1, new Consumable(
                "Dr. Pepper",
                "Yummy, delicious nectar of the gods",
                "\nYou drink your Dr. Pepper.\nYou feel powerful!",
                1,
                true,
                true,
                false,
                false,
                false,
                5));

    }
}
