package web.servlet.model;

public class Product {
	
	int pnum;
	String name;
	int price;
	String detail;
	
	public static final String DEFAULT_DETAIL = "와이드TV";	
	
	public Product() {}

	//MainServlet에서 이름, 가격만 입력할 때 사용
	public Product(String name, int price) {
		this(name, price, DEFAULT_DETAIL);
	}
	
	//MainServlet에서 이름, 가격, 상세 설명 입력할 때 사용
	public Product(String name, int price, String detail) {
		this.name = name;
		this.price = price;
		this.detail = detail;
	}

	//findProducts()에서 리스트 만들 때 사용
	public Product( int pnum, String name, int price, String detail) {
		this.pnum = pnum;
		this.name = name;
		this.price = price;
		this.detail = detail;
	}
	
	public int getNum() {
		return pnum;
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
		return "Product [pnum=" + pnum + ", name=" + name + ", price=" + price + ", detail=" + detail + "]";
	}

}
