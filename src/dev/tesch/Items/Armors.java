package dev.tesch.Items;

import java.util.HashMap;
import java.util.Map;

public class Armors {

    // HashMap the armors are stored in
    public Map<Integer, Armor> armorMap = new HashMap<>();

    public Armors() {

        armorMap.put(1, new Armor(
                "Cardboard Armor",
                "Protects from pointy sharp things.",
                "\nYou put on the cardboard armor.\nYou feel more protected.",
                true,
                false,
                true,
                true,
                false,
                10));
    }
}
