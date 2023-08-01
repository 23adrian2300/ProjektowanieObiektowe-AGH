package magazyn;

import kategorie.Kategoria;
import kategorie.Podkategoria;

import java.util.ArrayList;
import java.util.List;

public class MenadzerTowarow {
    private final ArrayList<Towar> towar = new ArrayList<>();
    private final ArrayList<Kategoria> kategorie = new ArrayList<>();
    private final ArrayList<Podkategoria> podkategorie = new ArrayList<>();

    public MenadzerTowarow() {
        towar.add(new Towar(100, "Adidas Ultraboost"));
        towar.add(new Towar(250, "Nike Air Max 270"));
        towar.add(new Towar(80, "FIFA 23"));
        towar.add(new Towar(40, "Minecraft"));
        towar.add(new Towar(120, "The Legend of Zelda: Breath of the Wild"));

        kategorie.add(new Kategoria("Odzież"));
        kategorie.get(0).getTower().add(towar.get(0));
        kategorie.get(0).getTower().add(towar.get(1));
        kategorie.add(new Kategoria("Gry"));
        kategorie.get(1).getTower().add(towar.get(2));
        kategorie.get(1).getTower().add(towar.get(3));
        kategorie.get(1).getTower().add(towar.get(4));

        podkategorie.add(new Podkategoria("Buty sportowe"));
        podkategorie.get(0).getDziecko().add(new Podkategoria("Puma"));
        podkategorie.get(0).getDziecko().add(new Podkategoria("Umbro"));
        podkategorie.get(0).getTower().add(towar.get(0));
        podkategorie.get(0).getTower().add(towar.get(1));

        podkategorie.add(new Podkategoria("Gry wideo"));
        podkategorie.get(1).getDziecko().add(new Podkategoria("RPG"));
        podkategorie.get(1).getDziecko().add(new Podkategoria("Wyscigowe"));
        podkategorie.get(1).getTower().add(towar.get(2));
        podkategorie.get(1).getTower().add(towar.get(3));
        podkategorie.get(1).getTower().add(towar.get(4));
    }
    public void wypiszWszytskieKategorie() {
        wypiszKategorie();
        wypiszPodkategorie();
    }

    private void wypiszKategorie() {
        System.out.println("==============");
        System.out.println("= Kategorie =");
        System.out.println("==============");
        for (Kategoria c : kategorie) {
            System.out.println(c.getNazwa());
            for (Towar m : c.getTower()) {
                System.out.println(m.getNazwa() + ", cena jednostkowa: " + m.getCena());
            }
            System.out.println();
        }
    }

    private void wypiszPodkategorie() {
        System.out.println("=================");
        System.out.println("= Podkategorie =");
        System.out.println("=================");
        for (Podkategoria sc : podkategorie) {
            wypiszPodkategorieProduktu(sc);
        }
    }

    private void wypiszPodkategorieProduktu(Podkategoria podkategoria) {
        System.out.println(podkategoria.getNazwa());
        for (Towar m : podkategoria.getTower()) {
            System.out.println(m.getNazwa() + ", cena jednostkowa: " + m.getCena());
        }
        System.out.println();
        for (Podkategoria sc : podkategoria.getDziecko()) {
            wypiszPodkategorieProduktu(sc);
        }
    }
}