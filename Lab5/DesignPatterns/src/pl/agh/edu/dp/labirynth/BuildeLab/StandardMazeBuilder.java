package pl.agh.edu.dp.labirynth.BuildeLab;

import pl.agh.edu.dp.labirynth.Direction;
import pl.agh.edu.dp.labirynth.MapSite;
import pl.agh.edu.dp.labirynth.Maze;
import pl.agh.edu.dp.labirynth.LabElements.Doors.Door;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.Factories.MazeFactory;

import static pl.agh.edu.dp.labirynth.Direction.*;

public class StandardMazeBuilder implements MazeBuilder {
    private final Maze currentMaze;
    private final MazeFactory factory;

    public StandardMazeBuilder(MazeFactory factory) {
        this.currentMaze = new Maze();
        this.factory = factory;
    }

    @Override
    public void addRoom(Room room) {
        room.setSide(South, factory.createWall());
        room.setSide(North, factory.createWall());
        room.setSide(East, factory.createWall());
        room.setSide(West, factory.createWall());
        currentMaze.addRoom(room);
    }

    @Override
    public void addDoor(Room room1, Room room2) throws Exception {
        Direction room1Door = null;
        for (Direction dir : values()) {
            if (room1.getSide(dir).equals(room2.getSide(dir.getOpposite()))) {
                room1Door = dir;
                break;
            }
        }
        if (room1Door == null) throw new Exception("Takie drzwi nie istnieja");
        else {
            Door newDoor = factory.createDoor(room1, room2);
            room1.setSide(room1Door, newDoor);
            room2.setSide(room1Door.getOpposite(), newDoor);
        }
    }

    @Override
    public void addCommonWall(Direction r1Direction, Room room1, Room room2) throws Exception {
        MapSite side = room1.getSide(r1Direction);
        if (side == null) throw new Exception("Taka sciana nie istnieje");
        room2.setSide(r1Direction.getOpposite(), side);
    }

    public Maze getCurrentMaze() {
        return this.currentMaze;
    }
}