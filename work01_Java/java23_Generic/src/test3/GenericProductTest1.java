package test3;


class Product<T1, T2, T3>{
	private T1 serialNumber; // 구체적으로 타입을 명시하지 않는다.
	private T2 brand;
	private T3 price;
	
	public Product(T1 serialNumber, T2 brand, T3 price) {
		this.serialNumber = serialNumber;
		this.brand = brand;
		this.price = price;
	}

	public T1 getSerialNumber() {
		return serialNumber;
	}

	public void setSerialNumber(T1 serialNumber) {
		this.serialNumber = serialNumber;
	}

	public T2 getBrand() {
		return brand;
	}

	public void setBrand(T2 brand) {
		this.brand = brand;
	}

	public T3 getPrice() {
		return price;
	}

	public void setPrice(T3 price) {
		this.price = price;
	}
	
}

public class GenericProductTest1 {
	public static void main(String[] args) {
		
		Product<Long, String, Double> p = new Product<>(112233L, "LG Gram", 17000000.1);
		System.out.println(p.getBrand() + ", " + p.getPrice());
		
	}
	
}
