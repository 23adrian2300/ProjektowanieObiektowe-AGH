package pl.edu.agh.dronka.shop.model.items;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.filter.MoreFilters;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class ItemsFood extends Item {

    public static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private final Date eatBeforeDate;

    public ItemsFood(String name, Category category, int price, int quantity, String eatBeforeInString) {
        super(name, category, price, quantity);
        try {
            this.eatBeforeDate = convertToDate(eatBeforeInString);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format");
        }
    }

    private Date convertToDate(String string) throws ParseException {
        return formatter.parse(string);
    }

    @Override
    public Map<String, Object> getExtraFieldsMap() {
        return new HashMap<>() {{
            put("Data przydatności do spożycia", eatBeforeDate);
        }};
    }

    @Override
    public boolean isExtraFieldsAppliedTo(MoreFilters filter) {
        return true;
    }
}