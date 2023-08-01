package pl.agh.edu.dp.labirynth.Factories;

import pl.agh.edu.dp.labirynth.LabElements.Doors.Door;
import pl.agh.edu.dp.labirynth.LabElements.Doors.EnchantedDoor;
import pl.agh.edu.dp.labirynth.LabElements.Room.EnchantedRoom;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.LabElements.Wall.EnchantedWall;
import pl.agh.edu.dp.labirynth.LabElements.Wall.Wall;

public class EnchantedMazeFactory extends MazeFactory {
    private static EnchantedMazeFactory instance;

    public static EnchantedMazeFactory getInstance(){
        if( instance == null){
            instance = new EnchantedMazeFactory();
        }
        return instance;
    }
    @Override
    public Door createDoor(Room room1, Room room2) {
        return new EnchantedDoor(room1, room2);
    }

    @Override
    public Room createRoom(int number) {
        return new EnchantedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new EnchantedWall();
    }
}