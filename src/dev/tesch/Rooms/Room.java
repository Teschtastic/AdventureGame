package dev.tesch.Rooms;

public class Room {

    public Room(String s) {
        setName(s);
    }

    private String enterMessage;
    private String name;
    private int location;
    private int[] moves;
    private boolean[] canMove;
    private boolean[] cannotMove;


    public String getEnterMessage() {
        return enterMessage;
    }

    public void setEnterMessage(String enterMessage) {
        this.enterMessage = enterMessage;
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

    public void enterMessage() {
        System.out.println("You've entered " + getName());
    }
}
