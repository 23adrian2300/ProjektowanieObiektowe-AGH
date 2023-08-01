package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pl.edu.agh.to.lab4.all.*;
import pl.edu.agh.to.lab4.all.searching.CompositeSearch;
import pl.edu.agh.to.lab4.all.searching.NameSearch;
import pl.edu.agh.to.lab4.all.simple.CracovCitizen;
import pl.edu.agh.to.lab4.all.simple.Prisoner;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;

    private PersonDataProvider personDataProvider;

    private PrisonersDatabase prisonersDatabase;

    private Finder suspectFinder;

    @Before
    public void setUp() {
        personDataProvider = new PersonDataProvider();
        prisonersDatabase = new PrisonersDatabase();
        suspectFinder = new Finder(new CompositeAggregate(Arrays.asList(personDataProvider, prisonersDatabase)));
    }

    @Test
    public void testDisplayingNotJailedPrisoner() {
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski",31, "802104543357", 2000, 1));
        suspectFinder.display(new CompositeSearch(Collections.singletonList(new NameSearch("Jan"))));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        suspectFinder.display(new CompositeSearch(Collections.singletonList(new NameSearch("Jan"))));
        assertContentIsDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 15));
        suspectFinder.display(new CompositeSearch(Collections.singletonList(new NameSearch("Jan"))));
        assertContentIsNotDisplayed("Jan Kowalski");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        personDataProvider.getAllCracovCitizens().add(new CracovCitizen("Jan", "Kowalski", 20));
        prisonersDatabase.addPrisoner("Wiezeienie stanowe", new Prisoner("Jan", "Kowalski2", 29,"802104543357", 2000, 27));
        suspectFinder.display(new CompositeSearch(Collections.singletonList(new NameSearch("Jan"))));
        assertContentIsNotDisplayed("Jan Kowalski2");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }
}