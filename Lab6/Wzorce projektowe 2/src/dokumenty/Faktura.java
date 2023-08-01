package dokumenty;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Date;

import konfiguracja.Konfiguracja;
import magazyn.Towar;
import rabaty.ObliczCenePoRabacie;


public class Faktura {
	Date dataSprzedazy;
	String kontrahent;
	ArrayList<Pozycja> pozycje;
	double suma;
	ObliczCenePoRabacie obliczCene;

	public Faktura(Date dataSprzedazy,String kontrahent)
	{
		this.dataSprzedazy=dataSprzedazy;
		this.kontrahent=kontrahent;
		pozycje=new ArrayList<Pozycja>();
		suma=0;
		obliczCene = Konfiguracja.getInstancja().getObliczCene();
	}
	public void dodajPozycje(Towar towar, double ilosc)
	{
		pozycje.add(new Pozycja(towar,ilosc));
		this.przeliczSume();
	}
	public double getSuma()
	{
		return suma;
	}

	public double getCalaCenaPoObnizce() {
		return obliczCene.obliczCenePoRabacie(getSuma());
	}

	public Date getDataSprzedazy()
	{
		return dataSprzedazy;
	}

	//jak sie zmieni cos na fakturze to trzeba wywolac te metode
	private void przeliczSume()
	{
		Iterator<Pozycja> iteratorPozycji=pozycje.iterator();
		Pozycja pozycja;
		suma=0;
		while(iteratorPozycji.hasNext())
		{
			pozycja = iteratorPozycji.next();
			suma+=pozycja.getWartosc();
		}
	}
	public Iterator<Pozycja> getIteratorPozycji()
	{
		return pozycje.iterator();
	}
	public String getKontrahent()
	{
		return this.kontrahent;
	}
}