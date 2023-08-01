package main;

import java.util.Calendar;

import konfiguracja.Konfiguracja;
import magazyn.MenadzerTowarow;
import magazyn.Towar;
import dokumenty.Faktura;
import rabatlosowy.LosowyRabat;

public class Ui {

	public static void main(String[] args) {
		Calendar teraz=Calendar.getInstance();


		Towar t1=new Towar(30,"bluzka");
		Towar t2=new Towar(50,"kurtka");
		Towar t3=new Towar(100,"spodnie");
		Towar t4=new Towar(124,"buty");

		Faktura f=new Faktura(teraz.getTime(),"Familia");
		f.dodajPozycje(t1,3);
		f.dodajPozycje(t2, 5);
		f.dodajPozycje(t3, 3);
		f.dodajPozycje(t4, 2);

		Konfiguracja.getInstancja().getWypiszFakture().drukujFakture(f);
		System.out.println("\n");

		LosowyRabat lr=new LosowyRabat();
		System.out.println("Wylosowany rabat: " + lr.losujRabat());
		//
		System.out.println("\n");
		MenadzerTowarow menadzerTowarow = new MenadzerTowarow();
		menadzerTowarow.wypiszWszytskieKategorie();
	}
}