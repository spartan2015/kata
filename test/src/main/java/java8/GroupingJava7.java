package java8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import static java.util.stream.Collectors.summarizingInt;

public class GroupingJava7 {
	static class Coffee {
		int size;
		String type;
		int price;

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public int getPrice() {
			return price;
		}

		public void setPrice(int price) {
			this.price = price;
		}

	}

	@Test
	public void cofee() {
		List<Coffee> coffeeInventory = new ArrayList<>();
		
		int totalQuantity = coffeeInventory.stream()
				.map(Coffee::getSize)
				.reduce(0, Integer::sum);
	}
	@Test
	public void group() {
		List<Coffee> coffeeInventory = new ArrayList<>();
		Map<Long, List<Coffee>> coffeeByPrice = new HashMap<>();
		for (Coffee coffee : coffeeInventory) {
			List<Coffee> atThisPrice = coffeeByPrice.get(coffee.getPrice());
			if (atThisPrice == null) {
				atThisPrice = new ArrayList<>();
				coffeeByPrice.put((long)coffee.getPrice(), atThisPrice);
			}
			atThisPrice.add(coffee);
		}

		IntSummaryStatistics menuStatistics = coffeeInventory.stream().collect(summarizingInt(Coffee::getPrice));
		menuStatistics.getAverage();
		menuStatistics.getCount();
		menuStatistics.getMax();
		menuStatistics.getMin();

	}
}
