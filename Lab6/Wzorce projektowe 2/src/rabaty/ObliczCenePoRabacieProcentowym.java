package rabaty;

import konfiguracja.Konfiguracja;

public class ObliczCenePoRabacieProcentowym implements ObliczCenePoRabacie {
//    public static final double znizka = 0.15;

    @Override
    public double obliczCenePoRabacie(double cena) {
        final double rabat = Konfiguracja.getInstancja().getRabatProcentowy();
        return Math.max((1 - rabat) * cena, 0);
    }
}