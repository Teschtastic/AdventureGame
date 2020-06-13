package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Items.Item;
import dev.tesch.Items.Items;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

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

        // List used for inventory
        List<Item> inventory = new ArrayList<>();

        // Scanners for player choices
        Scanner playerAction = new Scanner(System.in);

        // Vars used in player choice
        String choice;
        Integer roomIndex = 1;

        // Welcome message
        Actions.welcome();
        // Tells you which room you're in
        userRooms.get(roomIndex).getStartMessage();

        // Main game loop
        // TODO: Make output look prettier
        GAME:
        while(true) {
            Integer choiceIndex = null;

            // Scans the System.in for the next user choice
            Actions.typeChoice();
            choice = playerAction.nextLine();

            // Checks to see if the user choice is defined in the actions scope, then assigns it to an Integer
            for (Map.Entry<Integer, List<String>> entry: userActions.entrySet())
                if (entry.getValue().contains(choice.toLowerCase()))
                    choiceIndex = entry.getKey();

            if (choiceIndex == null)
                choiceIndex = -1;

            // Switch case to parse the user's choice
            switch (choiceIndex) {
                case 1:
                    // Accesses the inventory
                    Actions.inventory(inventory);
                    break;

                case 2:
                    // Accesses the help menu
                    Actions.help(userActions);
                    break;

                case 3:
                    // Prints your location
                    Actions.printLocation(roomIndex, userRooms);
                    break;

                case 4:
                    // Moves into a new room
                    roomIndex = Actions.move(userRooms, roomIndex);
                    break;

                case 5:
                    // Looks around the room
                    Actions.lookAround(userRooms, roomIndex, userItems);
                    break;

                case 0:
                    // Quits the game
                    Actions.exitMessage();
                    return;

                case -1:
                    // Input error
                    Actions.inputError();
                    continue GAME;

                default:
                    // Outputs a generic invalid choice message to the user
                    Actions.genericError();
                    break;
            }
        }
    }
}
