package filter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

class Product {

	private String name;
	private double price;
	private String category;

	public Product(String name, double price, String category) {
		this.name = name;
		this.price = price;
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public String getCategory() {
		return category;
	}

	@Override
	public String toString() {
		return "Product{" +
						"name='" + name + '\'' +
						", price=" + price +
						", category='" + category + '\'' +
						'}';
	}
}

public class FilterCustomObjects {

	public static void main(String[] args) {

		List<Product> products = new ArrayList<>();  //* source
		products.add(new Product("Phone", 999.99, "Electronic"));
		products.add(new Product("Short", 29.99, "Clothing"));
		products.add(new Product("TV", 1499.99, "Electronic"));
		products.add(new Product("Laptop", 1299.99, "Electronic"));
		products.add(new Product("Jeans", 59.99, "Clothing"));

		// todo create Stream from List
		//Stream<Product> stream = products.stream();
//		List<Product> filtered =
//						stream.filter(product -> product.getCategory().equals("Electronic"))
//						.toList();
//
//		filtered.forEach(System.out::println);

		//* multiple filter conditions
		Stream<Product> stream = products.stream();
		List<Product> filtered =
						stream.filter(product -> product.getCategory().equals("Electronic"))
										.filter(product -> product.getPrice() > 1000)
										.toList();
		filtered.forEach(System.out::println);
	}

}
