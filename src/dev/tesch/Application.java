package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;
import dev.tesch.save.LoadFromFile;

import java.util.List;
import java.util.Map;

public class Application {
    public static void main(String[] args) {

        // Actions object and HashMap
        Map<Integer, List<String>> userActions = new Actions().actionsMap;

        // Player object
        Player player = new Player();

        // Load player information from player files
        LoadFromFile.loadPlayerFromFile(player);

        // Running the main game loop
        ActionsParser.gameLoop(player, userActions);
    }
}
