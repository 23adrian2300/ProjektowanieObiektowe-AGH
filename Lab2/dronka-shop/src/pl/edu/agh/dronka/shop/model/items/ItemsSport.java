package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.MoreFilters;


import java.util.Map;

public class ItemsSport extends Item {

    public ItemsSport(String name, Category category, int price, int quantity) {
        super(name, category, price, quantity);
    }

    @Override
    public Map<String, Object> getExtraFieldsMap() {
        return null;
    }

    @Override
    public boolean isExtraFieldsAppliedTo(MoreFilters filter) {
        return true;
    }
}