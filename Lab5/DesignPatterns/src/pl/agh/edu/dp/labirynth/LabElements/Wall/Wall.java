package pl.agh.edu.dp.labirynth.LabElements.Wall;

import pl.agh.edu.dp.labirynth.MapSite;

public class Wall extends MapSite {
    public Wall(){}
    @Override
    public void Enter(){
        System.out.println("Uderzyles w normalna sciane");
    }
}