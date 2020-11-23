package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Furniture.Furniture;
import dev.tesch.Furniture.Furnitures;
import dev.tesch.Items.*;
import dev.tesch.NPCs.NPC;
import dev.tesch.NPCs.NPCs;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        // Player object
        Player player = new Player("Sean", 50, 100, 0, 10, new ArrayList<>(), 1);

        // Actions object and HashMap
        Actions actions = new Actions();
        Map<Integer, List<String>> userActions = actions.actionsMap;

        // NPCs object
        NPCs npcs = new NPCs();
        Map<Integer, NPC> userNpcs = npcs.npcMap;

        // Rooms object and HashMap
        Rooms rooms = new Rooms();
        Map<Integer, Room> userRooms = rooms.roomsMap;

        // Items object and HashMap
        Items items = new Items();
        Map<Integer, Item> userItems = items.itemsMap;

        // Furnitures object and HashMap
        Furnitures furnitures = new Furnitures();
        Map<Integer, Furniture> userFurnitures = furnitures.furnituresMap;

        // Armors object and HashMap
        Armors armors = new Armors();
        Map<Integer, Armor> userArmors = armors.armorMap;

        // Weapons object and HashMap
        Weapons weapons = new Weapons();
        Map<Integer, Weapon> userWeapons = weapons.weaponMap;

        // Running the main game loop
        ActionsParser.gameLoop(userActions, userNpcs, userRooms, userItems, userFurnitures, userArmors, userWeapons, player);
    }
}
