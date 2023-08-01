package pl.agh.edu.dp.labirynth;

import pl.agh.edu.dp.labirynth.BuildeLab.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.Factories.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.LabElements.Room.Room;
import pl.agh.edu.dp.labirynth.Factories.MazeFactory;
import pl.agh.edu.dp.Player.Player;

import java.util.Scanner;

import static pl.agh.edu.dp.labirynth.Direction.*;

public class MazeGame {

    private Player player;

    private static MazeGame instance;

    public static MazeGame getInstance() {
        if (instance == null) {
            instance = new MazeGame();
        }
        return instance;
    }
    public void movePlayerTo(Room room){
        player.setCurrentRoom(room);
    }
    public void start() {
        System.out.println("Wpisz -> q aby zakonczyc");
        System.out.println("Wpisz -> w/a/s/d aby sie poruszac");
        loop();
    }

    private void loop() {
        Scanner scan = new Scanner(System.in);
        while (true) {
            player.status();
            char c = scan.next().charAt(0);
            switch (c) {
                case 'w':
                    this.player.move(North);
                    break;
                case 's':
                    this.player.move(South);
                    break;
                case 'a':
                    this.player.move(West);
                    break;
                case 'd':
                    this.player.move(East);
                    break;
                case 'q':
                    endgame();
                    return;
                default:
                    System.out.println("Nieznana komenda: " + c);
                    break;
            }
        }
    }

    public void endgame() {
        System.out.println("Koniec...");
    }
    public void createMaze(StandardMazeBuilder builder, MazeFactory factory,EnchantedMazeFactory factory1) throws Exception {
        this.player = new Player(buildExampleMaze(builder, factory,factory1));
        Maze maze = builder.getCurrentMaze();
    }

    private Room buildExampleMaze(StandardMazeBuilder mazebuilder, MazeFactory factory, EnchantedMazeFactory factory1) throws Exception {
        Room[] rooms = new Room[9];
        for (int i = 0; i < 9; i++) {
            if (i>7){
                rooms[i] = factory1.createRoom(i);
                mazebuilder.addRoom(rooms[i]);
            }
            else{
            rooms[i] = factory.createRoom(i);
            mazebuilder.addRoom(rooms[i]);}
        }
        mazebuilder.addCommonWall(Direction.East, rooms[0], rooms[1]);
        mazebuilder.addCommonWall(Direction.South, rooms[0], rooms[3]);
        mazebuilder.addCommonWall(Direction.East, rooms[1], rooms[2]);
        mazebuilder.addCommonWall(Direction.South, rooms[1], rooms[4]);
        mazebuilder.addCommonWall(Direction.South, rooms[2], rooms[5]);
        mazebuilder.addCommonWall(Direction.East, rooms[3], rooms[4]);
        mazebuilder.addCommonWall(Direction.South, rooms[3], rooms[6]);
        mazebuilder.addCommonWall(Direction.East, rooms[4], rooms[5]);
        mazebuilder.addCommonWall(Direction.South, rooms[4], rooms[7]);
        mazebuilder.addCommonWall(Direction.South, rooms[5], rooms[8]);
        mazebuilder.addCommonWall(Direction.East, rooms[6], rooms[7]);
        mazebuilder.addCommonWall(Direction.East, rooms[7], rooms[8]);
        mazebuilder.addDoor(rooms[0], rooms[1]);
        mazebuilder.addDoor(rooms[1], rooms[2]);
        mazebuilder.addDoor(rooms[2], rooms[5]);
        mazebuilder.addDoor(rooms[4], rooms[5]);
        mazebuilder.addDoor(rooms[4], rooms[7]);
        mazebuilder.addDoor(rooms[7], rooms[8]);
        mazebuilder.addDoor(rooms[6], rooms[7]);
        mazebuilder.addDoor(rooms[3], rooms[6]);

        return rooms[0];
    }
}