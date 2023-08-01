package pl.agh.edu.dp.labirynth.LabElements.Room;

public class BombedRoom extends Room {
    public BombedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("Wszedles do zaminowanego pokoju");
    }
}