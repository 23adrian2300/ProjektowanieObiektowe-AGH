package pl.edu.agh.to.lab4.all;

import pl.edu.agh.to.lab4.all.searching.CompositeSearch;
import pl.edu.agh.to.lab4.all.simple.Suspect;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Finder {

    private final CompositeAggregate compositeAggregate;

    public Finder(CompositeAggregate compositeAggregate) {
        this.compositeAggregate = compositeAggregate;
    }

    public void display(CompositeSearch searchStrategy) {
        Iterator<Suspect> suspectIterator = compositeAggregate.iterator(searchStrategy);
        List<Suspect> suspects = new ArrayList<>();

        while(suspectIterator.hasNext() && suspects.size() < 10) {
            suspects.add(suspectIterator.next());
        }

        System.out.println("Znalazlem " + suspects.size() + " pasujacych podejrzanych!");
        suspects.forEach(System.out::println);
    }
}