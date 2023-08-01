package rabaty;

import konfiguracja.Konfiguracja;

public class ObliczCenePoRabacieKwotowym implements ObliczCenePoRabacie {
//    public static final double znizka = 10;

    @Override
    public double obliczCenePoRabacie(double cena) {
        final double rabat = Konfiguracja.getInstancja().getRabatCenowy();
        return Math.max(cena - rabat, 0);
    }
}