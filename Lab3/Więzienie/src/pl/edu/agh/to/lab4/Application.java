package pl.edu.agh.to.lab4;


import pl.edu.agh.to.lab4.all.*;
import pl.edu.agh.to.lab4.all.searching.AgeSearch;
import pl.edu.agh.to.lab4.all.searching.CompositeSearch;
import pl.edu.agh.to.lab4.all.searching.NameSearch;
import pl.edu.agh.to.lab4.dataGenerators.citizensGenerate;
import pl.edu.agh.to.lab4.dataGenerators.prisonersGenerate;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        PersonDataProvider personDataProvider = new PersonDataProvider();
        citizensGenerate.addPeopleData(personDataProvider);
        PrisonersDatabase prisonersDatabase = new PrisonersDatabase();
        prisonersGenerate.addPeopleData(prisonersDatabase);
        Finder suspects = new Finder(new CompositeAggregate(Arrays.asList(personDataProvider, prisonersDatabase)));
        suspects.display(new CompositeSearch(Arrays.asList(new NameSearch("Anita"), new AgeSearch(35))));
    }
}