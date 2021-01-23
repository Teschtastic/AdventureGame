package dev.tesch.Actions;

import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dev.tesch.Actions.Actions.*;

public class ActionsParser {

    public static void gameLoop(Player player, Map<Integer, List<String>> userActions, Map<Integer, Room> userRooms) {

        Scanner playerAction = new Scanner(System.in);                  // Scanner for player choices
        Actions.welcome();                                              // Welcome message
        player.getRoomIsIn().getStartMessage();                         // Tells you which room you're in

        while(true) {                                                   // Main game loop
            
            if(player.getCurrentHealth() <= 0)                          // Checks if player is dead, and ends game
                Actions.deathMessage();
            
            Integer choiceIndex = null;
            Actions.typeChoice();
            
            if (playerAction.hasNextLine())
                player.setChoice(playerAction.nextLine());              // Scans the System.in for the next user choice
            else
                playerAction.close();

            // Checks to see if the user choice is defined in the actions scope, then assigns it to an Integer
            for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
                if (entry.getValue().contains(player.getChoice().toLowerCase())) {
                    choiceIndex = entry.getKey();
                }
            }

            // If there was no action for the choice given, set to error choice
            // else use the choice given index above
            switch (choiceIndex != null ? choiceIndex : -1) {                       // Switch case to parse the user's choice
                case 1:
                    PlayerActions.inventory(player);                                // Accesses the inventory
                    break;

                case 2:
                    PlayerActions.help(userActions);                                // Accesses the help menu
                    break;

                case 3:
                    RoomActions.printLocation(player);                              // Prints your location
                    break;

                case 4:
                    RoomActions.move(player, userRooms);                            // Moves into a new room
                    break;

                case 5:
                    RoomActions.lookAround(player);                                 // Looks around the room
                    break;

                case 6:
                    ItemActions.pickupItem(player);                                 // Attempts to pickup an item
                    break;

                case 7:
                    PlayerActions.describeSomething(player);                               // Describes an item in your inventory
                    break;

                case 8:
                    ItemActions.dropItem(player);                                   // Drops an item into the current room
                    break;

                case 9:
                    PlayerActions.useSomething(player);                              // Uses something that can be used
                    break;

                case 10:
                    NPCActions.talkToNPC(player);                                   // Talks to the NPC in the room
                    break;

                case 11:
                    NPCActions.giveItem(player);                                    // Gives item to the NPC in the room
                    break;

                case 12:
                    NPCActions.takeItem(player);                                    // Gives item to the NPC in the room
                    break;

                case 13:
                    PlayerActions.describePlayer(player);                           // Describes the player character
                    break;

                case 14:
                    ItemActions.equipItem(player);                                  // Equips an item to player
                    break;

                case 15:
                    ItemActions.unEquipItem(player);                                // Un equips an item from player
                    break;

                case 0:
                    exitMessage();                                                  // Quits the game
                    break;

                case -1:
                    inputError();                                                   // Input error
                    break;

                default:
                    genericError();                                                 // Outputs a generic error to the user
                    break;
            }
        }
    }
}
