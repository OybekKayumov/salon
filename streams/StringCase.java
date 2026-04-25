import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StringCase {

	public static void main(String[] args) {

		List<String> words = Arrays.asList("apple", "banana", "orange", "cherry",
						"mango");

		List<String> result =
						words.stream().map(String::toUpperCase).toList();

		System.out.println(result);
		System.out.println();

		//* find average
		List<Integer> numbers = Arrays.asList(10, 20, 30, 40, 50);

		double average = numbers.stream()            //* convert into stream
						.mapToInt(n -> n.intValue())  //* convert Integer into int
						.average()                           //* calculate average
						.getAsDouble();

		System.out.println(average);

		//* find square
		List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		List<Integer> res = numbers2.stream()
						.filter(n -> n % 2 == 0)
						.limit(3)         //* limit to the first three even numbers
						.map(n -> n * n)
						.toList();
		System.out.println(res);

//[APPLE, BANANA, ORANGE, CHERRY, MANGO]
//30.0
//[4, 16, 36]
	}
}
