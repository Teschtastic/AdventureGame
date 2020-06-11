package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Rooms.Room;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {

        // Variables
        Actions actions = new Actions();
        Map<Integer, List<String>> userActions = actions.actionsMap;
        Room Apartment = new Room("Sean's apartment");
        Scanner input = new Scanner(System.in);
        String choice;
        Integer choiceIndex = null;

        // Welcome message
        Actions.welcome();

        // Main game loop
        // TODO: Make output look prettier
        while(true) {
            // Tells you which room you're in
            Apartment.getInMessage();

            // Scans the System.in for the next user choice
            Actions.typeChoice();
            choice = input.nextLine();

            // Checks to see if the user choice is defined in the actions scope, then assigns it to an Integer
            for (Map.Entry<Integer, List<String>> entry: userActions.entrySet()) {
                if (entry.getValue().contains(choice))
                    choiceIndex = entry.getKey();
            }

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

                case 0:
                    // Quits the game
                    Actions.exitMessage();
                    return;

                default:
                    // Outputs a generic invalid choice message to the user
                    Actions.error();
                    break;
            }
        }
    }
}
