package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.MoreFilters;

import java.util.HashMap;
import java.util.Map;

public class ItemsElectronics extends Item {

    private final boolean isMobile;
    private final boolean isWithWarranty;

    public ItemsElectronics(String name, Category category, int price, int quantity, boolean isMobile, boolean isUnderWarranty) {
        super(name, category, price, quantity);
        this.isMobile = isMobile;
        this.isWithWarranty = isUnderWarranty;
    }

    public boolean isMobile() {

        return isMobile;
    }

    @Override
    public Map<String, Object> getExtraFieldsMap() {
        return new HashMap<>() {{
            put("Mobilny", isMobile);
            put("Gwarancja", isWithWarranty);
        }};
    }

    @Override
    public boolean isExtraFieldsAppliedTo(MoreFilters filter) {
        if (filter.isMobile() && !isMobile()) {
            return false;
        }

        return !filter.isUnderWarranty() || isWithWarranty;
    }
}