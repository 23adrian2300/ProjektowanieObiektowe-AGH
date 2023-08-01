package pl.agh.edu.dp.labirynth.LabElements.Doors;

import pl.agh.edu.dp.labirynth.LabElements.Room.Room;

public class BombedDoor extends Door {
    public BombedDoor(Room room1, Room room2) {
        super(room1, room2);
    }

    @Override
    public void Enter() {
        System.out.println("Otworzyles zaminowane drzwi");
        getRoomAtOthersSide(getRoom1());
    }
}