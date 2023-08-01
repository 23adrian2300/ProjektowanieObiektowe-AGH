package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.ItemsFood;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class CreateFood implements ICreate {
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        String dateInString = reader.getValue(
                dataLine, "Data przydatności do spożycia");
        return new ItemsFood(name, category, price, quantity, dateInString);
    }
}