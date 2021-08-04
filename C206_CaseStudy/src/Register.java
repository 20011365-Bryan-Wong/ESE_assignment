// Bryan
public class Register {
	private int regNum;
	private int id;
	private String email;

	private String date;
	private static int latestId = 0;
	private static int latestId1 = 0;

	public Register(int regNum, int id, String email, String status, String date) {
		this.regNum = regNum;
		this.id = id;
		this.email = email;
		this.date = date;
	}

	public String toString() {
		return String.format("%-5d %-5s %-25s %-10s %-10s", getRegNum(), getId(), getEmail(), getStatus(), getDate());
	}

	public int getRegNum() {
		return regNum;
	}

	public int getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getStatus() {
		return "Pending";
	}

	public String getDate() {
		return date;
	}

	public static int generateId() {
		return ++latestId;
	}

	public static int generateReg() {
		return ++latestId1;
	}
}
