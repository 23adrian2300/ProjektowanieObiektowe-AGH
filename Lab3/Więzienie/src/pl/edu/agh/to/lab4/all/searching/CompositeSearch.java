package pl.edu.agh.to.lab4.all.searching;

import pl.edu.agh.to.lab4.all.simple.Suspect;

import java.util.List;
import java.util.function.Predicate;

public class CompositeSearch implements Predicate<Suspect> {

    private final List<Predicate<Suspect>> filters;

    public CompositeSearch(List<Predicate<Suspect>> filters) {
        this.filters = filters;
    }

    @Override
    public boolean test(Suspect suspect) {
        return filters.stream()
                .allMatch(suspectPredicate -> suspectPredicate.test(suspect));
    }
}