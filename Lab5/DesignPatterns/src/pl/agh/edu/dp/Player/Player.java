package pl.agh.edu.dp.Player;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.LabElements.Doors.Door;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.LabElements.Wall.Wall;

public class Player {
    private Room currentRoom;
    public Player(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public void move(Direction dir) {
        MapSite side = this.currentRoom.getSide(dir);
        side.Enter();
        if (side instanceof Door) {
            this.currentRoom = ((Door) side).getRoomAtOthersSide(currentRoom);
        }
    }

    public void status() {
        System.out.println("Numer pokoju: " + this.currentRoom.getRoomNo());
        for (Direction dir : Direction.values()) {
            String dirr = null;
            if (this.currentRoom.getSide(dir) instanceof Door) {
                if(dir.equals(Direction.West)){
                    dirr = "Zachodnie";
                }
                if(dir.equals(Direction.East)){
                    dirr = "Wschodnie";
                }
                if(dir.equals(Direction.South)){
                    dirr = "Poludniowe";
                }
                if(dir.equals(Direction.North)){
                    dirr = "Polnocne";
                }
                System.out.println(dirr + " drzwi");
            }
            if (this.currentRoom.getSide(dir) instanceof Wall) {
                if(dir.equals(Direction.West)){
                    dirr = "Zachodnia";
                }
                if(dir.equals(Direction.East)){
                    dirr = "Wschodnia";
                }
                if(dir.equals(Direction.South)){
                    dirr = "Poludniowa";
                }
                if(dir.equals(Direction.North)){
                    dirr = "Polnocna";
                }
                System.out.println(dirr + " sciana");
            } if (this.currentRoom.getSide(dir) instanceof Room) {
                if(dir.equals(Direction.West)){
                    dirr = "Zachodni";
                }
                if(dir.equals(Direction.East)){
                    dirr = "Wschodni";
                }
                if(dir.equals(Direction.South)){
                    dirr = "Poludniowy";
                }
                if(dir.equals(Direction.North)){
                    dirr = "Polnocny";
                }
                System.out.println(dirr + "pokoj");
            }
        }
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
    public Room getCurrentRoom() {
        return this.currentRoom;
    }
}