package kategorie;

import magazyn.Towar;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstrakcyjnaKategoria {
    protected final String nazwa;
    protected List<Towar> towary = new ArrayList<>();

    protected AbstrakcyjnaKategoria(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public List<Towar> getTower() {
        return towary;
    }
}