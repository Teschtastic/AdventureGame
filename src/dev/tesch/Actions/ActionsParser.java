package dev.tesch.Actions;

import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dev.tesch.Actions.Actions.*;

public class ActionsParser {

    public static void gameLoop(Map<Integer, List<String>> userActions, Map<Integer, NPC> userNpcs, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Player player) {

        Scanner playerAction = new Scanner(System.in);              // Scanners for player choices
        Actions.welcome();                                          // Welcome message
        userRooms.get(player.getRoomIsIn()).getStartMessage();      // Tells you which room you're in

        // TODO: Make output look prettier
        while(true) {                                               // Main game loop
            Integer choiceIndex = null;
            Actions.typeChoice();
            player.setChoice(playerAction.nextLine());              // Scans the System.in for the next user choice

            // Checks to see if the user choice is defined in the actions scope, then assigns it to an Integer
            for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
                if (entry.getValue().contains(player.getChoice().toLowerCase())) {
                    choiceIndex = entry.getKey();
                }
            }

            // If there was no action for the choice given, set to error choice
            if (choiceIndex == null)
                choiceIndex = -1;

            switch (choiceIndex) {                                                      // Switch case to parse the user's choice
                case 1:
                    PlayerActions.inventory(player);                                    // Accesses the inventory
                    break;

                case 2:
                    PlayerActions.help(userActions);                                    // Accesses the help menu
                    break;

                case 3:
                    RoomActions.printLocation(player, userRooms);                       // Prints your location
                    break;

                case 4:
                    RoomActions.move(player, userRooms);                                // Moves into a new room
                    break;

                case 5:
                    RoomActions.lookAround(player, userNpcs, userRooms, userItems);     // Looks around the room
                    break;

                case 6:
                    ItemActions.pickupItem(player, userRooms, userItems);            // Attempts to pickup an item
                    break;

                case 7:
                    ItemActions.describeItem(player);                            // Describes an item in your inventory
                    break;

                case 8:
                    ItemActions.dropItem(player, userRooms);                         // Drops an item into the current room
                    break;

                case 9:
                    ItemActions.useItem(player, userRooms);                          // Uses an item in your inventory
                    break;

                case 10:
                    NPCActions.talkToNPC(player, userNpcs, userRooms);                       // Talks to the NPC in the room
                    break;

                case 11:
                    ItemActions.giveItem(player, userRooms, userNpcs);               // Gives item to the NPC in the room
                    break;

                case 12:
                    ItemActions.takeItem(player, userRooms, userNpcs, userItems);    // Gives item to the NPC in the room
                    break;

                case 0:
                    exitMessage();                                                              // Quits the game
                    break;

                case -1:
                    inputError();                                                               // Input error
                    break;

                default:
                    genericError();                                                             // Outputs a generic error to the user
                    break;
            }
        }
    }
}
