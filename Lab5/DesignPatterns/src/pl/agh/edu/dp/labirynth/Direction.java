package pl.agh.edu.dp.labirynth;

public enum Direction {
    North(0), East(1), South(2), West(3);
    public final int value;

    private Direction(int value) {
        this.value = value;
    }

    public Direction getOpposite() {
        return judgment((this.value + 2) % 4);
    }

    public Direction judgment(int value) {
        switch (value) {
            case 0:
                return North;
            case 1:
                return East;
            case 2:
                return South;
            case 3:
                return West;
            default:
                return null;
        }
    }
}