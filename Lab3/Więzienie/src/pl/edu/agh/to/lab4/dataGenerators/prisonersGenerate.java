package pl.edu.agh.to.lab4.dataGenerators;

import pl.edu.agh.to.lab4.all.simple.Prisoner;
import pl.edu.agh.to.lab4.all.PrisonersDatabase;

public class prisonersGenerate {
    public static void addPeopleData(PrisonersDatabase prisonersDatabase) {
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Jan", "Kowalski", 27,"87080452357", 2005, 7));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Anita", "Wiercipieta", 35,"84080452357", 2009, 3));
        prisonersDatabase.addPrisoner("Wiezienie krakowskie", new Prisoner("Janusz", "Zlowieszczy", 67,"92080445657", 2001, 10));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Janusz", "Zamkniety",78, "802104543357", 2010, 5));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Adam", "Future", 89,"880216043357", 2020, 5));
        prisonersDatabase.addPrisoner("Wiezienie przedmiejskie", new Prisoner("Zbigniew", "Nienajedzony",31, "90051452335", 2011, 1));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Jan", "Przedziwny",19, "91103145223", 2009, 4));
        prisonersDatabase.addPrisoner("Wiezienie centralne", new Prisoner("Janusz", "Podejrzany", 52,"85121212456", 2012, 1));
    }
}
