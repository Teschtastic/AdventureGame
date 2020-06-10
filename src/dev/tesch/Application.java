package dev.tesch;

import dev.tesch.Actions.Actions;
import dev.tesch.Rooms.Room;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Actions.welcome();

        Room Apartment = new Room("Sean's apartment");
        Scanner in = new Scanner(System.in);
        Apartment.enterMessage();

        if (in.nextLine().charAt(0) == 'h')
            Actions.help();
    }
}
