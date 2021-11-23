package dev.tesch;

import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Containers;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Furniture.Furnitures;
import dev.tesch.NPCs.NPC;
import dev.tesch.NPCs.NPCs;

import java.util.Map;

public class AllObjects {
    // All Items Object
    public AllItems allItems;

    // Different NPC maps
    public Map<Integer, NPC>           npcs;

    // Different furniture maps
    public Map<Integer, Furniture>     furnitures;
    public Map<Integer, Container>     containers;

    public AllObjects() {
        allItems        = new AllItems();

        npcs            = new NPCs().npcMap;

        furnitures      = new Furnitures().furnituresMap;
        containers      = new Containers().containersMap;
    }
}
