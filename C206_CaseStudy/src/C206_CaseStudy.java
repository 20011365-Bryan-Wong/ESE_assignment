import java.util.ArrayList;

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
		ArrayList<TimeTable> timetableList = new ArrayList<TimeTable>();
		timetableList.add(new TimeTable(TimeTable.generateId(), 4.2, "20/04/2021", "20/09/2021", "ONLINE"));

		ArrayList<Register> registerList = new ArrayList<Register>();
		registerList.add(new Register(Register.generateReg(), Register.generateId(), "20011365@myrp.edu.sg", "Pending",
				"03/08/2021"));

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
					C206_CaseStudy.viewReg(registerList);

				} else if (tuitionType == VIEW_TUITION) {
					// Danish

				} else if (tuitionType == VIEW_TIMETABLE) {
					// YenTong
					C206_CaseStudy.viewTimeTable(timetableList);

				} else if (tuitionType == VIEW_STUDENTS) {
					// Keng Siong

				}
			} else if (option == ADD) {
				C206_CaseStudy.setHeader("ADD");
				C206_CaseStudy.tuitionTypeMenu();

				int tuitionType = Helper.readInt("Enter option to select tuition type > ");

				if (tuitionType == ADD_REG) {
					// Bryan
					Register addRegister = inputRegister();
					C206_CaseStudy.addRegister(registerList, addRegister);

				} else if (tuitionType == ADD_TUITION) {
					// Danish

				} else if (tuitionType == ADD_TIMETABLE) {
					// YenTong
					TimeTable addTime = inputTimeTable();
					C206_CaseStudy.addTimeTable(timetableList, addTime);

				} else if (tuitionType == ADD_STUDENTS) {
					// Keng Siong

				}
			} else if (option == DELETE) {
				C206_CaseStudy.setHeader("DELETE");
				C206_CaseStudy.tuitionTypeMenu();

				int tuitionType = Helper.readInt("Enter option to select tuition type > ");

				if (tuitionType == DELETE_REG) {
					// Bryan
					C206_CaseStudy.doDeleteReg(registerList);

				} else if (tuitionType == DELETE_TUITION) {
					// Danish

				} else if (tuitionType == DELETE_TIMETABLE) {
					// YenTong
					C206_CaseStudy.doDelete(timetableList);

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

	// ================================= Option 1 View (CRUD -
	// Read)=================================
	public static String retrieveTimetable(ArrayList<TimeTable> timetableList) {
		String output = "";
		for (int i = 0; i < timetableList.size(); i++) {
			output += String.format("%s\n", timetableList.get(i).toString());
		}
		return output;
	}

	public static void viewTimeTable(ArrayList<TimeTable> timetableList) {
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-5s %-10s %-13s %-13s %-10s\n", "ID", "PRICE", "START DATE", "END DATE",
				"MODE");
		output += retrieveTimetable(timetableList);
		System.out.println(output);
	}

	public static String retrieveRegister(ArrayList<Register> registerList) {
		String output = "";
		for (int i = 0; i < registerList.size(); i++) {
			output += String.format("%-5s \n", registerList.get(i).toString());
		}
		return output;
	}

	public static void viewReg(ArrayList<Register> registerList) {
		C206_CaseStudy.setHeader("REGISTRATION LIST");
		String output = String.format("%-5s %-5s %-25s %-10s %-10s \n", "NO.", "ID", "EMAIL", "STATUS", "DATE");
		output += retrieveRegister(registerList);
		System.out.println(output);
	}

	// ================================= Option 2 Add (CRUD -
	// Create)=================================
	public static TimeTable inputTimeTable() {
		double price = Helper.readDouble("Enter price > $");
		String startDate = Helper.readString("Enter Start Date > ");
		String endDate = Helper.readString("Enter End Date > ");
		String mode = Helper.readString("Enter Mode > ");

		Helper.line(80, "-");
		TimeTable tt = new TimeTable(TimeTable.generateId(), price, startDate, endDate, mode.toUpperCase());
		return tt;
	}

	public static void addTimeTable(ArrayList<TimeTable> timetableList, TimeTable tt) {
		timetableList.add(tt);
		System.out.println("TimeTable Added!");
	}

	public static Register inputRegister() {
		String email = Helper.readString("Enter email > ");
		String status = "";
		String date = Helper.readString("Enter Register Date > ");

		Helper.line(80, "-");
		Register r = new Register(Register.generateReg(), Register.generateId(), email, status, date);
		return r;
	}

	public static void addRegister(ArrayList<Register> registerList, Register r) {
		registerList.add(r);
		System.out.println("Registered!");
	}

	// ================================= Option 3 Delete (CRUD -
	// Delete)=================================

	public static boolean doFind(ArrayList<TimeTable> timetableList, int id) {
		boolean isFound = false;
		for (int i = 0; i < timetableList.size(); i++) {
			if (timetableList.get(i).getId() == id) {
				timetableList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	public static void doDelete(ArrayList<TimeTable> timetableList) {
		C206_CaseStudy.viewTimeTable(timetableList);
		int id = Helper.readInt("Enter id > ");
		Boolean isFound = doFind(timetableList, id);

		if (isFound == false) {
			System.out.println("Invalid ID");
		} else {
			System.out.println("Timetable (ID " + id + ") successfully deleted!");
		}
	}

	public static boolean doFindReg(ArrayList<Register> registerList, int reg) {
		boolean isFound = false;
		for (int i = 0; i < registerList.size(); i++) {
			if (registerList.get(i).getRegNum() == reg) {
				registerList.remove(i);
			}
		}
		return isFound;
	}

	public static void doDeleteReg(ArrayList<Register> registerList) {
		C206_CaseStudy.viewReg(registerList);
		int reg = Helper.readInt("Enter Registration No > ");
		Boolean isFound = doFindReg(registerList, reg);

		if (isFound == false) {
			System.out.println("Invalid Registration Number!");
		} else {
			System.out.println("Registration Number (ID" + reg + ") successfully deleted!");
		}
	}
}
