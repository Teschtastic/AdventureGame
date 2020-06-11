package dev.tesch.Rooms;

// Class for the structure of each room
// TODO: add more element for the rooms, also,
//  maybe change to abstract class and have separate class with the actual rooms
public class Room {

    public Room(String s) {
        setName(s);
        setInMessage(s);
    }

    private String enterMessage;
    private String inMessage;
    private String name;
    private int location;
    private int[] moves;
    private boolean[] canMove;
    private boolean[] cannotMove;


    public void getEnterMessage() {
        System.out.println(enterMessage);
    }

    public void setEnterMessage(String name) {
        this.enterMessage = "You've entered " + getName();
    }

    public void getInMessage() {
        System.out.println(inMessage);
    }

    public void setInMessage(String inMessage) {
        this.inMessage = "You're in " + getName();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public boolean[] getCanMove() {
        return canMove;
    }

    public int[] getMoves() {
        return moves;
    }

    public void setMoves(int[] moves) {
        this.moves = moves;
    }

    public void setCanMove(boolean[] canMove) {
        this.canMove = canMove;
    }

    public boolean[] getCannotMove() {
        return cannotMove;
    }

    public void setCannotMove(boolean[] cannotMove) {
        this.cannotMove = cannotMove;
    }
}
