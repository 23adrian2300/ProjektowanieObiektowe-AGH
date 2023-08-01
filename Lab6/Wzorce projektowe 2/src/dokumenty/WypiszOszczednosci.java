package dokumenty;

public class WypiszOszczednosci extends WypiszFakture {
    @Override
    protected void drukujRabat(Faktura faktura) {
        System.out.println("Zaoszczędzone pieniądze: " + (faktura.getSuma() - faktura.getCalaCenaPoObnizce()));
    }
}