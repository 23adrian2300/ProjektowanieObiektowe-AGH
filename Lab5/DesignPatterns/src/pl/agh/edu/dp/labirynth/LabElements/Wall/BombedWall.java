package pl.agh.edu.dp.labirynth.LabElements.Wall;

public class BombedWall extends Wall {
    public BombedWall(){
        super();
    }
    @Override
    public void Enter() {
        System.out.println("Uderzyles w zaminowana sciane");
    }
}