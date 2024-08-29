package web.servlet.vo;

public class Product {
	private int productNo;
	private String name;
	private int price;
	private String detail;
	
	public Product() { }
	
	public Product(String name, int price, String detail) {
		this.name = name;
		this.price = price;
		this.detail = detail;
	}

	public Product(int productNo, String name, int price, String detail) {
		this.productNo = productNo;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	
	public int getProductNo() {
		return productNo;
	}
	public void setProductNo(int productNo) {
		this.productNo = productNo;
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
		return "Product [productNo=" + productNo + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}
}
