package dev.tesch.Rooms;

import dev.tesch.Furniture.Furniture;
import dev.tesch.Items.Item;
import dev.tesch.NPCs.NPC;

// Class for the structure of each room
public class Room {

    // Constructing the room object
    public Room(
            int[] moves,
            int[] connections,
            String name,
            boolean hasItem,
            Item iIR,
            boolean hNPC,
            NPC npcIR,
            boolean hF,
            Furniture fIR) {

        setName(name);
        setStartMessage(name, moves);
        setInMessage(name);
        setEnterMessage(name, moves);
        setLeaveMessage(name);
        setMoves(moves);
        setConnectedRooms(connections);
        setHasItem(hasItem);
        setItemInRoom(iIR);
        setHasNPC(hNPC);
        setNpcInRoom(npcIR);
        setHasFurniture(hF);
        setFurnitureInRoom(fIR);
    }

    // Vars for room data
    private String name;                // Room name
    private String startMessage;        // Message used for if you start in that room
    private String enterMessage;        // Message for when you enter a room
    private String leaveMessage;        // Message for when you leave a room
    private String inMessage;           // Message for when you're already in a room
    private int[] moves;                // Directions [N, E, S, W] that are essentially exits
    private int[] connectedRooms;       // Stores either the rooms Key index if it's connected, or else -1
    private boolean hasItem;            // Flag for if there is an item in the room
    private Item itemInRoom;            // Item object in the room
    private boolean hasNPC;             // Flag for if there is an NPC in the room
    private NPC npcInRoom;              // NPC object in room
    private boolean hasFurniture;       // Flag for if there is furniture in the room
    private Furniture furnitureInRoom;  // Furniture object in room

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
                            getMoves(moves);

    }

    public void getEnterMessage() {
        System.out.println(enterMessage);
    }

    public void setEnterMessage(String name, int[] moves) {
        this.enterMessage = "You've entered " + name +
                            getMoves(moves);
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

    public int[] getMoveIndices() {
        return moves;
    }

    public String getMoves(int[] moves) {
        String[] directions = {"N", "E", "S", "W"};
        String move = "";

        for (int i = 0; i < directions.length; i++) {
            if (moves[i] == 1) {
                move = move.concat(" " + directions[i]);
            }
        }
        return "\nYou can move:" + move;
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

    public Item getItemInRoom() {
        return itemInRoom;
    }

    public void setItemInRoom(Item itemInRoom) {
        this.itemInRoom = itemInRoom;
    }

    public boolean isHasNPC() {
        return hasNPC;
    }

    public void setHasNPC(boolean hasNPC) {
        this.hasNPC = hasNPC;
    }

    public NPC getNpcInRoom() {
        return npcInRoom;
    }

    public void setNpcInRoom(NPC npcInRoom) {
        this.npcInRoom = npcInRoom;
    }

    public boolean isHasFurniture() {
        return hasFurniture;
    }

    public void setHasFurniture(boolean hasFurniture) {
        this.hasFurniture = hasFurniture;
    }

    public Furniture getFurnitureInRoom() {
        return furnitureInRoom;
    }

    public void setFurnitureInRoom(Furniture furnitureInRoom) {
        this.furnitureInRoom = furnitureInRoom;
    }
}
