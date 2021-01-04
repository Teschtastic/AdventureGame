package dev.tesch.Actions;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Armor;
import dev.tesch.Items.Item;
import dev.tesch.Items.Weapon;
import dev.tesch.NPCs.NPC;
import dev.tesch.Player.Player;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import static dev.tesch.Actions.Actions.*;

public class ActionsParser {

    public static void gameLoop(Map<Integer, List<String>> userActions, Map<Integer, NPC> userNPCs, Map<Integer, Room> userRooms, Map<Integer, Item> userItems, Map<Integer, Furniture> userFurnitures, Map<Integer, Armor> userArmors, Map<Integer, Weapon> userWeapons, Player player) {

        Scanner playerAction = new Scanner(System.in);              // Scanners for player choices
        Actions.welcome();                                          // Welcome message
        userRooms.get(player.getRoomIsIn()).getStartMessage();      // Tells you which room you're in

        while(true) {                                               // Main game loop
            
            if(player.getCurrentHealth() <= 0)
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
            switch (choiceIndex != null ? choiceIndex : -1) {                                                                                      // Switch case to parse the user's choice
                case 1:
                    PlayerActions.inventory(player);                                                                    // Accesses the inventory
                    break;

                case 2:
                    PlayerActions.help(userActions);                                                                    // Accesses the help menu
                    break;

                case 3:
                    RoomActions.printLocation(player, userRooms);                                                       // Prints your location
                    break;

                case 4:
                    RoomActions.move(player, userRooms);                                                                // Moves into a new room
                    break;

                case 5:
                    RoomActions.lookAround(player, userNPCs, userRooms, userItems, userFurnitures);                     // Looks around the room
                    break;

                case 6:
                    ItemActions.pickupItem(player, userRooms, userItems);                                               // Attempts to pickup an item
                    break;

                case 7:
                    ItemActions.describeItem(player, userItems, userRooms);                                             // Describes an item in your inventory
                    break;

                case 8:
                    ItemActions.dropItem(player, userRooms);                                                            // Drops an item into the current room
                    break;

                case 9:
                    PlayerActions.useSomething(player, userRooms, userItems, userArmors, userWeapons, userNPCs, userFurnitures);     // Uses an item in your inventory
                    break;

                case 10:
                    NPCActions.talkToNPC(player, userNPCs, userRooms);                                                  // Talks to the NPC in the room
                    break;

                case 11:
                    NPCActions.giveItem(player, userRooms, userNPCs);                                                   // Gives item to the NPC in the room
                    break;

                case 12:
                    NPCActions.takeItem(player, userRooms, userNPCs, userItems);                                        // Gives item to the NPC in the room
                    break;

                case 13:
                    PlayerActions.describePlayer(player);                                                               // Describes the player character
                    break;

                case 14:
                    ItemActions.equipItem(player);                                                                      // Equips an item to player
                    break;

                case 0:
                    exitMessage();                                                                                      // Quits the game
                    break;

                case -1:
                    inputError();                                                                                       // Input error
                    break;

                default:
                    genericError();                                                                                     // Outputs a generic error to the user
                    break;
            }
        }
    }
}
