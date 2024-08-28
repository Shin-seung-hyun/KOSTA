package web.servlet.vo;

public class Product {
	private int productNum;
	private String name;
	private int price;
	private String description;
	
	private static int idx = 1;
	
	public int getProductNum() {
		return productNum;
	}
	
	public Product(String name, int price, String description) {
		this.productNum = idx++;
		this.name = name;
		this.price = price;
		this.description = description;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
