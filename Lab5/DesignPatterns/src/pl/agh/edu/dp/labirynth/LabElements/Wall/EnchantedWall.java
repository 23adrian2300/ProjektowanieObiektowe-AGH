package pl.agh.edu.dp.labirynth.LabElements.Wall;

public class EnchantedWall extends Wall {
    public EnchantedWall(){
        super();
    }

    @Override
    public void Enter() {
        System.out.println("Uderzyles w zaczarowana sciana");
    }
}