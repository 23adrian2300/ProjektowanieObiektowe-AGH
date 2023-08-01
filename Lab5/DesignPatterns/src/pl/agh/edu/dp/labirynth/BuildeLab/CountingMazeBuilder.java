package pl.agh.edu.dp.labirynth.BuildeLab;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;

public class CountingMazeBuilder implements MazeBuilder {
    private int elementsNumber = 0;

    @Override
    public void addRoom(Room room) {
        elementsNumber += 5;

    }

    @Override
    public void addDoor(Room room1, Room room2) throws Exception {
        elementsNumber++;
    }

    @Override
    public void addCommonWall(Direction roomDirection, Room room1, Room room2) throws Exception {
        elementsNumber--;
    }

    int GetCounts() {
        return elementsNumber;
    }
}