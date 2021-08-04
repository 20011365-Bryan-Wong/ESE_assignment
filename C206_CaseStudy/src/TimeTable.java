// Yentong
public class TimeTable {
	private int id;
	private double price;
	private String startDate;
	private String endDate;
	private String mode;
	private static int latestId = 0;

	public TimeTable(int id, double price, String startDate, String endDate, String mode) {
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
		this.mode = mode;
	}

	public String toString() {
		return String.format("%-5s $%-9.2f %-13s %-13s %-10s", getId(), getPrice(), getStartDate(), getEndDate(),
				getMode());
	}

	public int getId() {
		return id;
	}

	public double getPrice() {
		return price;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public String getMode() {
		return mode;
	}

	public static int generateId() {
	   return ++latestId;
	}
}
