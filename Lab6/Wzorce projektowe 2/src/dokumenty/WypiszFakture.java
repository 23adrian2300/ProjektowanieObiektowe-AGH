package dokumenty;

import java.util.Iterator;

public class WypiszFakture {
    public void drukujFakture(Faktura faktura) {
        drukujNaglowek(faktura);
        drukujPozycje(faktura);
        drukujRabat(faktura);
        drukujStopke(faktura);
    }

    protected void drukujNaglowek(Faktura faktura) {
        System.out.println("=====================================================");
        System.out.println("Faktura z dnia: " + faktura.getDataSprzedazy().toString());
        System.out.println("Wystawiona dla: " + faktura.getKontrahent());
    }

    protected void drukujPozycje(Faktura faktura) {
        Iterator<Pozycja> iteratorPozycji = faktura.getIteratorPozycji();
        while(iteratorPozycji.hasNext())
        {
            Pozycja pozycja = iteratorPozycji.next();
            System.out.println("Towar: " + pozycja.getNazwa() + " Ilosc: " + pozycja.getIlosc() + " Wartosc:" + pozycja.getWartosc());
        }
    }

    protected void drukujRabat(Faktura faktura) {}

    protected void drukujStopke(Faktura faktura) {
        System.out.println("Na kwote: " + faktura.getSuma());
        System.out.println("=====================================================");
    }
}