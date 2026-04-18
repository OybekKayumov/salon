package filter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamFilteringExample {

	public static void main(String[] args) {

		//* source
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		//todo traditional way of filtering even numbers from list
		List<Integer> evenNumbers = new ArrayList<>();
		for(Integer number : numbers) {
			if(number % 2 == 0) {
				evenNumbers.add(number);
			}
		}
		System.out.println(evenNumbers);
		//* [2, 4, 6, 8, 10]

		System.out.println("-".repeat(40));
		//todo using Stream API to filter even numbers from list
		Stream<Integer> stream = numbers.stream();
		List<Integer> evenNumbersFiltered =
						stream.filter(number -> number % 2 == 0).toList();
		System.out.println(evenNumbersFiltered);

	}
}
