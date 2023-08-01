package pl.agh.edu.dp.labirynth.LabElements.Room;

public class EnchantedRoom extends Room {
    public EnchantedRoom(int number) {
        super(number);
    }

    @Override
    public void Enter() {
        System.out.println("Wszedles do zaczarowanego pokoju");
    }
}