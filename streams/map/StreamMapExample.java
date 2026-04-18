package map;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMapExample {

	public static void main(String[] args) {

		List<String> fruits = Arrays.asList("apple", "banana", "orange");
		Stream<String> stream = fruits.stream();

		List<String> list = stream
														.peek((e) -> System.out.println(e))
														.map((e) -> e.toUpperCase())
														.peek((e) -> System.out.println(e))
														.collect(Collectors.toList());

		System.out.println(list);

//apple
//APPLE
//banana
//BANANA
//orange
//ORANGE
//* [APPLE, BANANA, ORANGE]


	}
}
