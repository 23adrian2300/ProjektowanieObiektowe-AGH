package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.ItemsBook;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class CreateBook implements ICreate {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        int numberOfPages  = Integer.parseInt(reader.getValue(dataLine, "Liczba stron"));
        boolean isHardCover = Boolean.parseBoolean(reader.getValue(
                dataLine, "Twarda oprawa"));
        return new ItemsBook(name, category, price, quantity, numberOfPages, isHardCover);
    }
}