package map;

import java.util.Arrays;
import java.util.List;

public class StreamMap2 {

	public static void main(String[] args) {

		List<String> listOfStrings = Arrays.asList("1", "2", "3", "4", "5");
		//* strings

		List<Integer> list = listOfStrings.stream()
				.map((e) -> Integer.valueOf(e))
						.toList();

		System.out.println(list);
		//* [1, 2, 3, 4, 5]

	}
}
