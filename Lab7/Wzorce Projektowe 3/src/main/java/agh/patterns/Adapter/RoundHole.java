package agh.patterns.Adapter;


public class RoundHole {
    private final int radius;
    public RoundHole(int radius) {
        this.radius = radius;
    }
    public int getRadius() {
        return radius;
    }

    public boolean fits(RoundPeg peg){
        return this.getRadius()>=peg.getRadius();
    }

}