package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.ItemsSport;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class CreateSport implements ICreate {
    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        return new ItemsSport(name, category, price, quantity);
    }
}