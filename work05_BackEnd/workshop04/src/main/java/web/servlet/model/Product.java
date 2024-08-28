package web.servlet.model;

public class Product {
	
	int num;
	String name;
	int price;
	String detail;
	
	public Product() {}

	public Product(int num, String name, int price, String detail) {
		super();
		this.num = num;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	@Override
	public String toString() {
		return "Product [num=" + num + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}
	
	
	
	
	
//	public Product(String name, int price, String detail) {
//		super();
//		this.name = name;
//		this.price = price;
//		this.detail = detail;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public int getPrice() {
//		return price;
//	}
//	public void setPrice(int price) {
//		this.price = price;
//	}
//	public String getDetail() {
//		return detail;
//	}
//	public void setDetail(String detail) {
//		this.detail = detail;
//	}
//	
//	@Override
//	public String toString() {
//		return "Product [name=" + name + ", price=" + price + ", detail=" + detail + "]";
//	}	

}
