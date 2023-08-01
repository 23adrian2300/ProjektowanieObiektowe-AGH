package pl.edu.agh.dronka.shop.model.filter;

import pl.edu.agh.dronka.shop.model.Item;

public class ItemFilter {

	private final MoreFilters filter = new MoreFilters();

	public MoreFilters getFilter() {
		return filter;
	}

	public boolean appliesTo(Item item) {

		if (filter.getCategory() != null
				&& !filter.getCategory().equals(item.getCategory())) {
			return false;
		}

		if (filter.isSecondHand() && !item.isSecondhand()) {
			return false;
		}
		if (filter.isPolish() && !item.isPolish()) {
			return false;
		}

		return item.isExtraFieldsAppliedTo(filter);
	}
}