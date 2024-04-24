package school;

public class studentDetails {
	private String name;
	private int id;
	private int rollNum;
	private int std;
	private int age;
	private String phoneNumber;
	studentDetails(){
		
	}
	studentDetails(String name, int id, int rollNum, int std, int age, String phoneNumber){
		this.name=name;
		this.id=id;
		this.rollNum=rollNum;
		this.std=std;
		this.age=age;
		this.phoneNumber=phoneNumber;
		
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id=id;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	public int getStd() {
		return std;
	}
	public void setStd(int std) {
		this.std = std;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	
}
