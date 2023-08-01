package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.MoreFilters;

import java.util.HashMap;
import java.util.Map;

public class ItemsBook extends Item {

    private final int numberOfPages;
    private final boolean isHardCover;

    public ItemsBook(String name, Category category, int price, int quantity, int numberOfPages, boolean isHardCover) {
        super(name, category, price, quantity);
        this.numberOfPages = numberOfPages;
        this.isHardCover = isHardCover;
    }

    @Override
    public Map<String, Object> getExtraFieldsMap() {
        return new HashMap<>() {{
            put("Liczba stron", numberOfPages);
            put("Twarda oprawa", isHardCover);
        }};
    }

    @Override
    public boolean isExtraFieldsAppliedTo(MoreFilters filter) {

        return !filter.isHardCover() || isHardCover;
    }
}