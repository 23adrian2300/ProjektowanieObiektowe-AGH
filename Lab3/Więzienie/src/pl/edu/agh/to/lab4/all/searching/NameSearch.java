package pl.edu.agh.to.lab4.all.searching;

import pl.edu.agh.to.lab4.all.simple.Suspect;

import java.util.function.Predicate;

public class NameSearch implements Predicate<Suspect> {

    private final String name;

    public NameSearch(String name) {
        this.name = name;
    }

    @Override
    public boolean test(Suspect suspect) {
        return suspect.getName().equals(name);
    }
}