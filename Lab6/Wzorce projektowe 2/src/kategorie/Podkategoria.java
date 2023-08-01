package kategorie;

import java.util.ArrayList;
import java.util.List;

public class Podkategoria extends AbstrakcyjnaKategoria {
    private final List<Podkategoria> dziecko = new ArrayList<>();

    public Podkategoria(String nazwa) {
        super(nazwa);
    }

    public List<Podkategoria> getDziecko() {
        return dziecko;
    }
}