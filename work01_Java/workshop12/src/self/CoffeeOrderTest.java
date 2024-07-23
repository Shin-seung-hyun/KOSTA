package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CoffeeOrderTest {

	public static void main(String[] args) {
		
		
		// list 선언과 초기화 같이하는 법
		List<String> list = List.of("A", "B"); // JAVA 9 이상부터 가능
		List<String> list2 = Arrays.asList("A", "B");
		List<String> list3 = new ArrayList<>(){
		    {
		        add("A");
		        add("B");
		    }
		};
		
		List<String> coffees = Arrays.asList(
				"Cappuccino",
				"Americano",
				"Espresso",
				"Caramel Macchiato",
				"Mocha",
				"Cappuccino",
				"Espresso",
				"Latte" );
		
		//방법 1)
		coffees.stream()
				.filter(item->item.endsWith("o"))
				.sorted()
				.distinct()
				.forEach(i -> System.out.println(i + " "));
		
		//방법 2)
		List<String> coffeeEndingIn = coffees.stream()
				.filter(s->s.endsWith("o"))
				.sorted()
				.distinct()
				.collect(Collectors.toList());
		
		System.out.println(coffeeEndingIn);
	
	}

}
