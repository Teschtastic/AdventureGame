package dev.tesch.NPCs;

import java.util.HashMap;
import java.util.Map;

public class NPCs {

    // HashMap the NPCs are stored in
    public Map<Integer, NPC> npcMap = new HashMap<>();

    public NPCs() {
        npcMap.put(1, new NPC(
                "Claudia",
                "Hi Seanie!",
                100,
                true,
                false,
                null));

        npcMap.put(2, new NPC(
                "Jeff",
                "Hi bitch!",
                100,
                true,
                false,
                null));

        npcMap.put(3, new NPC(
                "Michaela",
                "My Man!",
                100,
                true,
                false,
                null));
    }
}
