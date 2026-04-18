package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilterStringList {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("apple", "orange", "banana", "grape",
						"mango", "cherry", "pineapple");

		//* traditional
		List<String> filteredFruits = new ArrayList<>();

		for (String fruit : fruits) {

			if (fruit.equals("banana")) {
				filteredFruits.add(fruit);
			}
		}
		System.out.println(filteredFruits);

		System.out.println("-".repeat(40));

		//* using stream
		List<String> result = fruits.stream()
						.filter(fruit -> fruit.equals("banana"))
						.toList();

		System.out.println(result);
	}
}
