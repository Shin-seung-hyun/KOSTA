package self.bank;

public class Customer {
	
	private String name;
	private int ssn; //고객의 주민번호 필수 정보
	
	private Address address;
	private Account account;
	
	//주소값 입력이 안됐을 경우, 기본값을 상수로 지정
	public static final String DEFAULT_NAME = "종각";
	
	public Customer() {}
	
	//생성자 Overloading :: 필수값만으로 객체생성을 할 수 있도록 하는 기법
	//		              이때, 입력받지 않은 값을 지정한 상수값으로 채워지도록 하는 기법이다.
	//	 				  null이 들어가지 않는다.
	//생성자 앞에 쓰인 this 는 :: 하나의 클래스에서 또 다른 생성자를 호출하는 기능으로 쓰인다.
	public Customer(int ssn, Address address, Account account) {	
		//name 은 ""이 아닌 default 값으로 채움
			//24 line 호출됨
		this(DEFAULT_NAME, ssn, address, account);
		
	}
	
	public Customer(String name, int ssn, Address address, Account account) {		
		this.name = name;
		this.ssn = ssn;
		this.address = address;
		this.account = account;
	}

	public Customer(String name, int ssn, Address address) {		
		this(name, ssn, address, null);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		this.ssn = ssn;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", ssn=" + ssn + ", address=" + address + ", account=" + account + "]";
	}
	
}



























