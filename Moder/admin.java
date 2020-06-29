package Moder;

public class admin {
	private int id;
	private String name;
	private String password;
	private String createDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public admin(int id, String name, String password, String createDate) {
		super();
		this.id = id;
		this.name = name;
		this.password = password;
		this.createDate = createDate;
	}
	public admin() {
		super();
	}
	@Override
	public String toString() {
		return "admin [id=" + id + ", name=" + name + ", password=" + password + ", createDate=" + createDate + "]";
	}
	
	
}
