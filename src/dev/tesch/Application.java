package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Items.Item;
import dev.tesch.Items.Items;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {
        /* ~ Variables ~ */
        // Actions HashMap
        Actions actions = new Actions();
        Map<Integer, List<String>> userActions = actions.actionsMap;

        // Rooms object and HashMap
        Rooms rooms = new Rooms();
        Map<Integer, Room> userRooms = rooms.roomsMap;

        // Items object and HashMap
        Items items = new Items();
        Map<Integer, Item> userItems = items.itemsMap;

        // Player object
        Player player = new Player("Sean", 100, 10, new ArrayList<>());

        // Running the main game loop
        ActionsParser.parseActions(userActions, userRooms, userItems, player);
    }
}
