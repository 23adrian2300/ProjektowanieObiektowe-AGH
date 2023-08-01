package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.ItemsElectronics;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class CreateElectronics implements ICreate {

    @Override
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        boolean isMobile = Boolean.parseBoolean(reader.getValue(
                dataLine, "Mobilny"));
        boolean isUnderWarranty = Boolean.parseBoolean(reader.getValue(
                dataLine, "Gwarancja"));
        return new ItemsElectronics(name, category, price, quantity, isMobile, isUnderWarranty);
    }
}