package dev.tesch.NPCs;

import java.util.HashMap;
import java.util.Map;

public class NPCs {
    // HashMap the NPCs are stored in
    public Map<Integer, NPC> npcMap = new HashMap<>();

    public NPCs() {
        npcMap.put(1, new NPC("Claudia", "Hi Seanie!", 1, 100, true, 1, false, -1));
        npcMap.put(2, new NPC("Jeff", "Hi bitch!", 2, 2, false, 5, false, -1));
    }
}
