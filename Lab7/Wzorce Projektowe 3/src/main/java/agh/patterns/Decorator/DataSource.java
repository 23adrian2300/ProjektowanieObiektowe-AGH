package agh.patterns.Decorator;

public interface DataSource {
    void writeData(String data);
    String readData();
}