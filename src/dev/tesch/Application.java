package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Rooms.Room;
import dev.tesch.Rooms.Rooms;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        /* ~ Variables ~ */

        // Actions object and HashMap
        Actions actions = new Actions();
        Map<Integer, List<String>> userActions = actions.actionsMap;

        // Rooms object and HashMap
        Rooms rooms = new Rooms();
        Map<Integer, Room> userRooms = rooms.roomsMap;

        // Scanners for player choices
        Scanner playerAction = new Scanner(System.in);
        Scanner moveAction = new Scanner(System.in);
        Scanner itemAction = new Scanner(System.in);
        Scanner npcAction = new Scanner(System.in);

        // Vars used in player choice
        String choice;
        Integer choiceIndex = null;
        Integer roomIndex = 1;

        // Welcome message
        Actions.welcome();
        // Tells you which room you're in
        userRooms.get(roomIndex).getStartMessage();

        // Main game loop
        // TODO: Make output look prettier
        GAME:
        while(true) {

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
                    Actions.inventory();
                    break;

                case 2:
                    // Accesses the help menu
                    Actions.help();
                    break;

                case 3:
                    // Prints your location
                    Actions.printLocation(roomIndex, userRooms);
                    break;

                case 4:
                    // Moves into a new room
                    roomIndex = Actions.move(moveAction, userRooms, roomIndex);
                    userRooms.get(roomIndex).getEnterMessage();
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
                    continue GAME;
            }
        }
    }
}
