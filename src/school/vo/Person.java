package school.vo;

public class Person {
	private String pName;
	private String id;
	private String phone;

	//생성자
	public Person() {}
	
	public Person(String pName, String id) {
		this.pName = pName;
		this.id = id;
		phone="";
	}

	public Person(String pName, String id, String phone) {
		this.pName = pName;
		this.id = id;
		this.phone = phone;
	}
	
	//getter, setter
	public String getName() {
		return pName;
	}
	public void setName(String pName) {
		this.pName = pName;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	//toString overriding
	public String toString() {
		String s="이름:"+pName+" ID코드:"+id+" 전화번호:"+phone;
		return s;
	}
}
