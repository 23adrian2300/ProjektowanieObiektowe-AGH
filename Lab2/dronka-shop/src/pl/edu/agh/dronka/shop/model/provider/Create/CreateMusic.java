package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.Item;
import pl.edu.agh.dronka.shop.model.items.GenreMusic;
import pl.edu.agh.dronka.shop.model.items.ItemsMusic;
import pl.edu.agh.dronka.shop.model.provider.CSVReader;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class CreateMusic implements ICreate {
    public Item createItem(String name, Category category, int price, int quantity, String[] dataLine, CSVReader reader) {
        String genreValue = reader.getValue(dataLine, "Gatunek muzyczny");
        GenreMusic genre = GenreMusic.valueOf(genreValue);
        String isVideoPresentValue = reader.getValue(dataLine, "Dołączone video");
        boolean isVideoPresent = Boolean.parseBoolean(isVideoPresentValue);
        return new ItemsMusic(name, category, price, quantity, genre, isVideoPresent);
    }}
