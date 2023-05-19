package kdgjava;

public class member {
	private String id;
	private String password;
	private String name;
	private String birth;
	private String tel;
	private String address;
	private int postal;
	private boolean admin;
	
	public member(String id, String password, String name, String birth, String tel, String address, int postal, boolean admin) {
		this.id = id;
		this.password = password;
		this.name = name;
		this.birth = birth;
		this.tel = tel;
		this.address = address;
		this.postal = postal;
		this.admin = admin;
	}
	
	public String getId() { return id; }
	public void setId(String id) { this.id = id; }
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	public String getName() { return name; }
	public void setName(String name) { this.name = name; }
	public String getBirth() { return birth; }
	public void setBirth(String birth) { this.birth = birth; }
	public String getTel() { return tel; }
	public void setTel(String tel) { this.tel = tel; }
	public String getAddress() { return address; }
	public void setAddress(String address) { this.address = address; }
	public int getPostal() { return postal; }
	public void setPostal(int postal) { this.postal = postal; }
	public boolean isAdmin() { return admin; }
	public void setAdmin(boolean admin) { this.admin = admin;}
	
}
