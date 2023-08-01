package pl.edu.agh.dronka.shop.model.util;

import java.util.LinkedHashMap;
import java.util.Map;

import pl.edu.agh.dronka.shop.model.Item;

public class PropertiesHelper {

	public static Map<String, Object> getPropertiesMap(Item item) {
		Map<String, Object> propertiesMap = new LinkedHashMap<>();
		//zmieniłem nazwy dla lepszego wygladu
		propertiesMap.put("Nazwy", item.getName());
		propertiesMap.put("Cena", item.getPrice());
		propertiesMap.put("Kategoria", item.getCategory().getDisplayName());
		propertiesMap.put("Ilosc", item.getQuantity());
		propertiesMap.put("Czy polskie", item.isPolish());
		propertiesMap.put("Czy uzywany", item.isSecondhand());

		Map<String, Object> additionalPropertiesMap = item.getExtraFieldsMap();
		if (additionalPropertiesMap != null) {
			propertiesMap.putAll(additionalPropertiesMap);
		}

		return propertiesMap;
	}
}