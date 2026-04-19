import java.util.Arrays;
import java.util.List;

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
	}
}
