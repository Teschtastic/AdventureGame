package dev.tesch.Rooms;

// Class for the structure of each room
// TODO: add more element for the rooms, also,
//  maybe change to abstract class and have separate class with the actual rooms
public class Room {

    // Constructing the room object
    public Room(Integer index, int[] moves, int[] connections, String name, boolean hasItem, int iIR) {
        setName(name);
        setStartMessage(name);
        setInMessage(name);
        setEnterMessage(name);
        setLeaveMessage(name);
        setLocation(index);
        setMoves(moves);
        setConnectedRooms(connections);
        setHasItem(hasItem);
        setItemInRoom(iIR);
    }

    // Vars for room data
    private String name;            // Room name
    private String startMessage;    // Message used for if you start in that room
    private String enterMessage;    // Message for when you enter a room
    private String leaveMessage;    // Message for when you leave a room
    private String inMessage;       // Message for when you're already in a room
    private int location;           // Int value for which room you're in
    private int[] moves;            // Directions [N, E, S, W] that are essentially exits
    private int[] connectedRooms;   // Stores either the rooms Key index if it's connected, or else -1
    private boolean hasItem;        // Tells if there is an item in the room
    private int itemInRoom;         // Int used to show which item is in the room

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getStartMessage() {
        System.out.println(startMessage);
    }

    public void setStartMessage(String name) {
        this.startMessage = "You start in " + name;;
    }

    public void getEnterMessage() {
        System.out.println(enterMessage);
    }

    public void setEnterMessage(String name) {
        this.enterMessage = "You've entered " + name;
    }

    public void getLeaveMessage() {
        System.out.println(leaveMessage);
    }

    public void setLeaveMessage(String name) {
        this.leaveMessage = "You've left " + name;
    }

    public void getInMessage() {
        System.out.println(inMessage);
    }

    public void setInMessage(String name) {
        this.inMessage = "\nYou're in " + name;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public int[] getMoves() {
        return moves;
    }

    public void setMoves(int[] moves) {
        this.moves = moves;
    }

    public int[] getConnectedRooms() {
        return connectedRooms;
    }

    public void setConnectedRooms(int[] connectedRooms) {
        this.connectedRooms = connectedRooms;
    }

    public boolean isHasItem() {
        return hasItem;
    }

    public void setHasItem(boolean hasItem) {
        this.hasItem = hasItem;
    }

    public int getItemInRoom() {
        return itemInRoom;
    }

    public void setItemInRoom(int itemInRoom) {
        this.itemInRoom = itemInRoom;
    }
}
