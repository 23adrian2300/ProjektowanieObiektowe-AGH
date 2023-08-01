package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.MoreFilters;


import java.util.HashMap;
import java.util.Map;

public class ItemsMusic extends Item {

    private final GenreMusic genre;
    private final boolean isVideoPresent;

    public ItemsMusic(String name, Category category, int price, int quantity, GenreMusic genre, boolean isVideoPresent) {
        super(name, category, price, quantity);
        this.genre = genre;
        this.isVideoPresent = isVideoPresent;
    }

    @Override
    public Map<String, Object> getExtraFieldsMap() {
        return new HashMap<>() {{
            put("Gatunek muzyczny", genre.toString());
            put("Dołączone video", isVideoPresent);
        }};
    }

    @Override
    public boolean isExtraFieldsAppliedTo(MoreFilters filter) {
        return !filter.isWithVideo() || isVideoPresent;
    }
}