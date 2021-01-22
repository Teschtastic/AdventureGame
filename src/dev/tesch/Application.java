package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Actions.ActionsParser;
import dev.tesch.Crafting.Recipe;
import dev.tesch.Crafting.Recipes;
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

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Application {

    public static void main(String[] args) {

        // Actions object and HashMap
        Map<Integer, List<String>> userActions = new Actions().actionsMap;

        // Rooms object and HashMap
        Map<Integer, Room> userRooms = new Rooms().roomsMap;

        // Recipes object and LinkedList
       List<Recipe> recipesList = new Recipes().recipesList;

        // Player object
        Player player = new Player(
                "Sean",
                50,
                100,
                0,
                10,
                new LinkedList<>(),
                1,
                false,
                false,
                recipesList);

        // Running the main game loop
        ActionsParser.gameLoop(player, userActions, userRooms);
    }
}
