package dev.tesch.Rooms;

// Class for the structure of each room
// TODO: add more element for the rooms, also,
//  maybe change to abstract class and have separate class with the actual rooms
public class Room {

    // Constructing the room object
    public Room(int index, int[] moves, int[] connections, String name, boolean hasItem, int iIR, boolean hNPC, int npcInR) {
        setName(name);
        setStartMessage(name, moves);
        setInMessage(name);
        setEnterMessage(name, moves);
        setLeaveMessage(name);
        setRoomIndex(index);
        setMoves(moves);
        setConnectedRooms(connections);
        setHasItem(hasItem);
        setItemInRoom(iIR);
        setHasNPC(hNPC);
        setNpcInRoom(npcInR);
    }

    // Vars for room data
    private String name;            // Room name
    private String startMessage;    // Message used for if you start in that room
    private String enterMessage;    // Message for when you enter a room
    private String leaveMessage;    // Message for when you leave a room
    private String inMessage;       // Message for when you're already in a room
    private int roomIndex;          // Int value for which room you're in
    private int[] moves;            // Directions [N, E, S, W] that are essentially exits
    private int[] connectedRooms;   // Stores either the rooms Key index if it's connected, or else -1
    private boolean hasItem;        // Flag for if there is an item in the room
    private int itemInRoom;         // Int used to show which item is in the room
    private boolean hasNPC;         // Flag for if there is an NPC in the room
    private int npcInRoom;          // Int to tell which NPC is in the room

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

    public void setStartMessage(String name, int[] moves) {
        this.startMessage = "You start in " + name +
                            "\nYou can move" + getMoves(moves);

    }

    public void getEnterMessage() {
        System.out.println(enterMessage);
    }

    public void setEnterMessage(String name, int[] moves) {
        this.enterMessage = "You've entered " + name +
                            "\nYou can move" + getMoves(moves);
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

    public int getRoomIndex() {
        return roomIndex;
    }

    public void setRoomIndex(int roomIndex) {
        this.roomIndex = roomIndex;
    }

    public int[] getMoveIndices() {
        return moves;
    }

    public String getMoves(int[] moves) {
        String[] directions = {"N", "E", "S", "W"};
        String move = new String();
        int[] mvs = moves;

        for (int i = 0; i < directions.length; i++) {
            if (mvs[i] == 1) {
                move = move.concat(" " + directions[i]);
            }
        }
        return move;
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

    public boolean isHasNPC() {
        return hasNPC;
    }

    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }

    public int getNpcInRoom() {
        return npcInRoom;
    }

    public void setNpcInRoom(int npcInRoom) {
        this.npcInRoom = npcInRoom;
    }
}
