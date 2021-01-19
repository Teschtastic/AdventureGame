package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Furniture.Container;
import dev.tesch.Furniture.Containers;
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
        Map<Integer, List<String>> userActions = new Actions().actionsMap;

        // NPCs object
        Map<Integer, NPC> userNpcs = new NPCs().npcMap;

        // Rooms object and HashMap
        Map<Integer, Room> userRooms = new Rooms().roomsMap;

        // Items object and HashMap
        Map<Integer, Item> userItems = new Items().itemsMap;

        // Consumables object and HashMap
        Map<Integer, Consumable> userConsumables = new Consumables().consumablesMap;

        // Armors object and HashMap
        Map<Integer, Armor> userArmors = new Armors().armorMap;

        // Weapons object and HashMap
        Map<Integer, Weapon> userWeapons = new Weapons().weaponMap;

        // Furnitures object and HashMap
        Map<Integer, Furniture> userFurnitures = new Furnitures().furnituresMap;

        // Containers object and HashMap
        Map<Integer, Container> userContainers = new Containers().containersMap;

        // Running the main game loop
        ActionsParser.gameLoop(
                player,
                userActions,
                userNpcs,
                userRooms,
                userItems,
                userConsumables,
                userArmors,
                userWeapons,
                userFurnitures,
                userContainers);
    }
}
