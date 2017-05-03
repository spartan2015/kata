package java8;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamApiDoneManually {

	static class Apple{
		int weight;
		String color;
		public int getWeight() {
			return weight;
		}
		public void setWeight(int weight) {
			this.weight = weight;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		
		
	}
	
	public static void main(String[] args){
		
		List<Apple> apples = new LinkedList();
		
		// map and filter: group by color, number of apples
		Map<String, Long> filteredApples = new HashMap<String,Long>();		
		for(Apple apple : apples){
			Long count = filteredApples.get(apple.getColor());
			Long newCount = count != null ? count++ : Long.valueOf(1);
			filteredApples.put(apple.getColor(), newCount);						
		}
		
		filteredApples = apples.stream().collect(Collectors.groupingBy(Apple::getColor, Collectors.counting()));
		
		apples.parallelStream().filter(a->a.getWeight()>100).collect(Collectors.toList());
		
	}
}
