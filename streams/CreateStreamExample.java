import java.util.*;
import java.util.stream.Stream;

public class CreateStreamExample {

	public static void main(String[] args) {

		//todo create stream from List
		List<String> fruitList2 = new ArrayList<>();
		fruitList2.add("banana");
		fruitList2.add("mango");
		fruitList2.add("apple");
		fruitList2.add("orange");

		List<String> fruitList =
						Arrays.asList("banana", "mango", "apple",	"orange");

		//* create stream from List (source)
		Stream<String> stream = fruitList.stream();
		stream.forEach((e) -> System.out.println(e));

		System.out.println("-".repeat(40));

		//todo create stream from Set
		Set<String> fruitSet = new HashSet<>(fruitList);
		Stream<String> stream1 = fruitSet.stream();
		stream1.forEach(System.out::println);

		System.out.println("-".repeat(40));

		//todo create stream from Map
		Map<String, Integer> fruitMap = new HashMap<>();
		fruitMap.put("Apple", 10);
		fruitMap.put("Mango", 15);
		fruitMap.put("Orange", 20);
		fruitMap.put("Banana", 5);

		//* create a Stream from Map's entrySet
		Stream<Map.Entry<String, Integer>> mapEntryStream =
																						fruitMap.entrySet().stream();
		//mapEntryStream.forEach((e) -> System.out.println(e.getKey()));
		mapEntryStream.forEach(System.out::println);
//		Apple=10
//		Mango=15
//		Orange=20
//		Banana=5

		System.out.println("-".repeat(40));

		//* create a Stream from Map's keySet
		Stream<String> mapKeySetStream = fruitMap.keySet().stream();

		mapKeySetStream.forEach(System.out::println);

//    Apple
//    Mango
//    Orange
//    Banana

		System.out.println("-".repeat(40));

		//* create a Stream from Map's values
		Stream<Integer> mapValuesStream = fruitMap.values().stream();
		mapValuesStream.forEach(System.out::println);

//		10
//		15
//		20
//		5

		System.out.println("-".repeat(40));

		//todo create stream from an Array
		String[] strArray = {"banana", "mango", "apple", "orange"};  //* source
		Arrays.stream(strArray).forEach(System.out::println);

		System.out.println("-".repeat(40));

		//* create Stream using Stream.of() method
		Stream.of("banana", "mango", "apple", "orange")
						.forEach(System.out::println);

	}
}
