package school.vo;

public class Teacher extends Person {

	private int salary;

	public Teacher() {
		super();
	}
	
	
	public Teacher(String name, String id, String phone, int salary) {
		super(name,id,phone);
		this.salary = salary;
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		String a="";
		setName(a);
		this.salary = salary;
	}
	
	public String toString() {
		String s=super.toString()+" 월급 : "+salary;
		return s;
	}
}