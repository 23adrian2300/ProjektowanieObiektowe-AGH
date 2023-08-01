package pl.agh.edu.dp.labirynth.LabElements.Doors;

import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.MazeGame;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;

public class Door extends MapSite {
    private Room room1;
    private final Room room2;

    public Door(Room room1, Room room2){
        this.room1 = room1;
        this.room2 = room2;
    }

    public Room getRoomAtOthersSide(Room firstR) {
        return room1 == firstR ? room2 : room1;
    }
    void movePlayerToOtherSide(){
        Room newRoom = getRoomAtOthersSide(room1);
        newRoom.Enter();
        MazeGame.getInstance().movePlayerTo(newRoom);
    }
    @Override
    public void Enter() {
        System.out.println("Otworzyles normalne drzwi");
        getRoomAtOthersSide(room1);
    }

    public Room getRoom1() {
        return room1;
    }

    public void setRoom1(Room room1) {
        this.room1 = room1;
    }

    public Room getRoom2() {
        return room2;
    }

    public void setRoom2(Room room2) {
        this.room1 = room2;
    }
}
