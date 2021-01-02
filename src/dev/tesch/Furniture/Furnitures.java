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
                "Crafting Table",
                "Used to craft things.\nPresumably.",
                "\nYou attempt to craft an item.",
                2,
                7,
                true));

        furnituresMap.put(3, new Furniture(
                "Sean's Bed",
                "Used for sleeping and other things.",
                "\nYou lay in the bed.",
                3,
                1,
                true));

        furnituresMap.put(4, new Furniture(
                "Jeff's Bed", 
                "Used for sleeping and other things.", 
                "\nYou lay in the bed.",
                4, 
                5, 
                true));
    }
}
