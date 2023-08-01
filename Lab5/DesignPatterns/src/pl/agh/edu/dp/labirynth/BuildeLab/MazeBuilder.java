package pl.agh.edu.dp.labirynth.BuildeLab;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;

public interface MazeBuilder {
    void addRoom(Room room);
    void addDoor(Room room1, Room room2) throws Exception;
    void addCommonWall(Direction roomDirection, Room room1, Room room2) throws Exception;
}