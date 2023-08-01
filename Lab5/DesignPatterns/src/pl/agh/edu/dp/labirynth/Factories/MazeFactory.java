package pl.agh.edu.dp.labirynth.Factories;

import pl.agh.edu.dp.labirynth.LabElements.Doors.Door;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.LabElements.Wall.Wall;

public class MazeFactory {
    private static MazeFactory instance;

    public static MazeFactory getInstance(){
        if( instance == null){
            instance = new MazeFactory();
        }
        return instance;
    }
    public Door createDoor(Room room1, Room room2) {
        return new Door(room1, room2);
    }

    public Room createRoom(int number) {
        return new Room(number);
    }

    public Wall createWall() {
        return new Wall();
    }
}