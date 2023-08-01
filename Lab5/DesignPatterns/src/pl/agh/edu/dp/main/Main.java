package pl.agh.edu.dp.main;

import pl.agh.edu.dp.labirynth.*;
import pl.agh.edu.dp.labirynth.BuildeLab.StandardMazeBuilder;
import pl.agh.edu.dp.labirynth.Factories.EnchantedMazeFactory;
import pl.agh.edu.dp.labirynth.Factories.MazeFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        MazeGame mazeGame = new MazeGame();
        MazeFactory mazeFactory = MazeFactory.getInstance();
        EnchantedMazeFactory Factory = EnchantedMazeFactory.getInstance();
        StandardMazeBuilder builder = new StandardMazeBuilder(mazeFactory);
        mazeGame.createMaze(builder, mazeFactory,Factory);
        mazeGame.start();
    }
}
