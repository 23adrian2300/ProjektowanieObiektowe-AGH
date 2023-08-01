package pl.agh.edu.dp.labirynth.Factories;

import pl.agh.edu.dp.labirynth.LabElements.Room.BombedRoom;
import pl.agh.edu.dp.labirynth.LabElements.Wall.BombedWall;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.LabElements.Wall.Wall;

public class BombedMazeFactory extends MazeFactory {
    private static BombedMazeFactory instance;

    public static BombedMazeFactory getInstance(){
        if( instance == null){
            instance = new BombedMazeFactory();
        }
        return instance;
    }
    @Override
    public Room createRoom(int number) {
        return new BombedRoom(number);
    }

    @Override
    public Wall createWall() {
        return new BombedWall();
    }
}