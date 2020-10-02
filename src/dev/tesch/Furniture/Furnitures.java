package dev.tesch.Furniture;

import java.util.HashMap;
import java.util.Map;

public class Furnitures {

    // HashMap the rooms are stored in
    public Map<Integer, Furniture> furnituresMap = new HashMap<>();

    public Furnitures() {

        furnituresMap.put(1, new Furniture(
                "Camping chair",
                "The only furniture in the living room",
                "\nThe chair's magical properties seem\nto have healed you to full health",
                1,
                9,
                true));

        furnituresMap.put(2, new Furniture(
                "Desktop PC",
                "My AMD beast",
                "\nYou use the PC to play some games.",
                2,
                1,
                true));

    }
}
