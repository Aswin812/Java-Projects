
public class management {
	private String name;
	private int age;
	private String gender;
	private String berth;
	
	management(){
	}
	management(String name,int id, int age, String gender, String berth){
		this.name=name;
		this.id=id;
		this.age=age;
		this.gender=gender;
		this.berth=berth;
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
		this.id = id;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBerth() {
		return berth;
	}
	public void setBerth(String berth) {
		this.berth = berth;
	}
	private int id;
	
}
