//KengSiong
public class Student {
	private String name;
	private String gender;
	private int mobile;
	private String email;
	private String DoB;
	private String CoR;
	private int YearJoined;
	private static String latestStudent;
	
	public Student(String name, String gender, int mobile, String email, String doB, String coR, int yearJoined) {
		this.name = name;
		this.gender = gender;
		this.mobile = mobile;
		this.email = email;
		DoB = doB;
		CoR = coR;
		YearJoined = yearJoined;
	}
	public String toString() {
		return String.format("%-5s %-5s %-25s %-10s %-10s %-10s %-20", getName(), getGender(),getMobile(), getEmail(), getDoB(), getCoR(), getYearJoined());
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getMobile() {
		return mobile;
	}

	public void setMobile(int mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDoB() {
		return DoB;
	}

	public void setDoB(String doB) {
		DoB = doB;
	}

	public String getCoR() {
		return CoR;
	}

	public void setCoR(String coR) {
		CoR = coR;
	}

	public int getYearJoined() {
		return YearJoined;
	}

	public void setYearJoined(int yearJoined) {
		YearJoined = yearJoined;
	}
	public static String generateStudent() {
		   return latestStudent;
		}

	}
