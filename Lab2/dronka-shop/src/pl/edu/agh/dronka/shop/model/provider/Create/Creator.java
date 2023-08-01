package pl.edu.agh.dronka.shop.model.provider.Create;

import pl.edu.agh.dronka.shop.model.Category;
import pl.edu.agh.dronka.shop.model.provider.ICreate;

public class Creator {

    public static ICreate create(Category category) {
        switch (category) {
            case BOOKS -> {
                return new CreateBook();
            }
            case ELECTRONICS -> {
                return new CreateElectronics();
            }
            case SPORT -> {
                return new CreateSport();
            }
            case FOOD -> {
                return new CreateFood();
            }
            case MUSIC -> {
                return new CreateMusic();
            }
            default ->
                throw new IllegalArgumentException("This catagory is not exist: " + category);

        }
    }
}