
public class Tuition {
	private int tuitCode;
	private String title;
	private String subject;
	private String desc;
	private int duration;
	private String prerequisite;
	private static int generateCode = 0;

	public Tuition(int tuitCode, String title, String subject, String desc, int duration, String prerequisite) {
		this.tuitCode = tuitCode;
		this.title = title;
		this.subject = subject;
		this.desc = desc;
		this.duration = duration;
		this.prerequisite = prerequisite;
	}

	public String toString() {
		return String.format("%-25d %-15s %-15s %-16s %-22s %-10s", Tuition.generateCode()-1, title(), subject(), desc(), duration(),prerequisite());

	}

	public int tuitCode() {
		return tuitCode;
	}

	public String title() {
		return title;
	}

	public String subject() {
		return subject;
	}

	public String desc() {
		return desc;
	}

	public int duration() {
		return duration;
	}
	public static int generateCode() {
		return ++generateCode;
	}
	public String prerequisite() {
		return prerequisite;
	}
}

