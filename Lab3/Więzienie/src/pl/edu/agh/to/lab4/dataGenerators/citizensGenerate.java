package pl.edu.agh.to.lab4.dataGenerators;

import pl.edu.agh.to.lab4.all.simple.CracovCitizen;
import pl.edu.agh.to.lab4.all.PersonDataProvider;

public class citizensGenerate {
    public static void addPeopleData(PersonDataProvider personDataProvider) {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 30));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Krakowski", 30));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Mlodociany", 10));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Kasia", "Kosinska", 19));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Piotr", "Zgredek", 29));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Tomek", "Gimbus", 14));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Gimbus", 15));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Alicja", "Zaczarowana", 22));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Janusz", "Programista", 77));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jarek", "Maka", 42));
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Krzysztof", "Mendel", 30));
    }
}
