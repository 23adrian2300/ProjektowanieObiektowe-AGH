package konfiguracja;

import dokumenty.WypiszOszczednosci;
import dokumenty.WypiszFakture;
import rabaty.ObliczCenePoRabacie;
import rabaty.ObliczCenePoRabacieProcentowym;

public class Konfiguracja {
    private static Konfiguracja konfiguracja = null;
    private final double rabatProcentowy;
    private final double rabatCenowy;
    private final ObliczCenePoRabacie obliczCene;
    private final WypiszFakture wypiszFakture;

    private Konfiguracja() {
        rabatProcentowy = 0.15; // wielkosc rabatu procentowego
        rabatCenowy = 10; // wielkosc rabatu cenowego
        obliczCene = new ObliczCenePoRabacieProcentowym();
        wypiszFakture = new WypiszOszczednosci();
    }

    public static Konfiguracja getInstancja() {
        if (konfiguracja == null)
            konfiguracja = new Konfiguracja();

        return konfiguracja;
    }

    public double getRabatProcentowy() {
        return rabatProcentowy;
    }

    public double getRabatCenowy() {
        return rabatCenowy;
    }

    public ObliczCenePoRabacie getObliczCene() {
        return obliczCene;
    }

    public WypiszFakture getWypiszFakture() {
        return wypiszFakture;
    }
}