package rabaty;

public class LosowyRabat implements ObliczCenePoRabacie {
    @Override
    public double obliczCenePoRabacie(double cena) {
        final double rabat = new rabatlosowy.LosowyRabat().losujRabat();
        return Math.max((1 - rabat) * cena, 0);
    }
}