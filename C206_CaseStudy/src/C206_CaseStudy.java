
public class C206_CaseStudy {
	private static final int OPTION_QUIT = 4;
	private static final int VIEW = 1;
	private static final int VIEW_REG = 1;
	private static final int VIEW_TUITION = 2;
	private static final int VIEW_TIMETABLE = 3;
	private static final int VIEW_STUDENTS = 4;

	private static final int ADD = 2;
	private static final int ADD_REG = 1;
	private static final int ADD_TUITION = 2;
	private static final int ADD_TIMETABLE = 3;
	private static final int ADD_STUDENTS = 4;

	private static final int DELETE = 3;
	private static final int DELETE_REG = 1;
	private static final int DELETE_TUITION = 2;
	private static final int DELETE_TIMETABLE = 3;
	private static final int DELETE_STUDENTS = 4;

	public static void main(String[] args) {
		int option = 0;

		while (option != OPTION_QUIT) {
			C206_CaseStudy.menu();
			option = Helper.readInt("Enter an option > ");

			if (option == VIEW) {
				C206_CaseStudy.setHeader("VIEW");
				C206_CaseStudy.tuitionTypeMenu();

				int tuitionType = Helper.readInt("Enter option to select tuition type > ");

				if (tuitionType == VIEW_REG) {
					// Bryan

				} else if (tuitionType == VIEW_TUITION) {
					// Danish

				} else if (tuitionType == VIEW_TIMETABLE) {
					// YenTong

				} else if (tuitionType == VIEW_STUDENTS) {
					// Keng Siong

				}
			} else if (option == ADD) {
				C206_CaseStudy.setHeader("ADD");
				C206_CaseStudy.tuitionTypeMenu();

				int tuitionType = Helper.readInt("Enter option to select tuition type > ");

				if (tuitionType == ADD_REG) {
					// Bryan

				} else if (tuitionType == ADD_TUITION) {
					// Danish

				} else if (tuitionType == ADD_TIMETABLE) {
					// YenTong

				} else if (tuitionType == ADD_STUDENTS) {
					// Keng Siong

				}
			} else if (option == DELETE) {
				C206_CaseStudy.setHeader("DELETE");
				C206_CaseStudy.tuitionTypeMenu();

				int tuitionType = Helper.readInt("Enter option to select tuition type > ");

				if (tuitionType == DELETE_REG) {
					// Bryan

				} else if (tuitionType == DELETE_TUITION) {
					// Danish

				} else if (tuitionType == DELETE_TIMETABLE) {
					// YenTong

				} else if (tuitionType == DELETE_STUDENTS) {
					// Keng Siong

				}
			} else if (option == OPTION_QUIT) {
				System.out.println("Thank You For Using This App!");
			} else {
				System.out.println("Invalid Option!");
			}
		}

	}

	public static void menu() {
		C206_CaseStudy.setHeader("Tuition Management System");
		System.out.println("1. Display Tuition");
		System.out.println("2. Add Tuition");
		System.out.println("3. Delete Tuition");
		System.out.println("4. Quit");
		Helper.line(80, "-");

	}

	public static void setHeader(String header) {
		Helper.line(80, "-");
		System.out.println(header);
		Helper.line(80, "-");
	}

	public static void tuitionTypeMenu() {
		C206_CaseStudy.setHeader("Tuition Types");
		System.out.println("1. Registration");
		System.out.println("2. Tuition");
		System.out.println("3. Tuition Timetable");
		System.out.println("4. Students");
	}
}
