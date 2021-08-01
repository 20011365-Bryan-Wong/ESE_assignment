
public class TimeTable {
	private int id;
	private double price;
	private String startDate;
	private String endDate;
	// To-do mode

	public TimeTable(int id, double price, String startDate, String endDate) {
		this.id = id;
		this.price = price;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String toString() {

		// Write your codes here
		return String.format("%-10s %-10s %-10s %-10s", getId(), getPrice(), getStartDate(), getEndDate());
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

}
