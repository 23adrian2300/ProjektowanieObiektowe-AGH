package pl.edu.agh.to.lab4.all;

import pl.edu.agh.to.lab4.all.simple.Suspect;

import java.util.Iterator;
import java.util.function.Predicate;

public interface SuspectAggregate {
    Iterator<Suspect> iterator(Predicate<Suspect> filter);
}