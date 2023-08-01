package pl.edu.agh.to.lab4.all.searching;

import pl.edu.agh.to.lab4.all.simple.Suspect;

import java.util.function.Predicate;

public class AgeSearch implements Predicate<Suspect> {

    private final int age;

    public AgeSearch(int age) {
        this.age = age;
    }

    @Override
    public boolean test(Suspect suspect) {
        return suspect.getAge() == age;
    }
}