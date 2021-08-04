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
		
		ArrayList<Student> studentList = new ArrayList<Student>();
		studentList.add(new Student("keng Siong", "M", 98765432, "20011945@rp.edu.sg", "14/12/2002", "Singapore", 2021));

		ArrayList<Tuition> tuitionList = new ArrayList<Tuition>();
		tuitionList.add(new Tuition(Tuition.generateCode()-1, "001", "Biology 2", "biology", 2, "Biology level 1"));

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
					C206_CaseStudy.viewTuition(tuitionList);

				} else if (tuitionType == VIEW_TIMETABLE) {
					// YenTong
					C206_CaseStudy.viewTimeTable(timetableList);

				} else if (tuitionType == VIEW_STUDENTS) {
					// Keng Siong
					C206_CaseStudy.viewStudent(studentList);

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
					Tuition addTuition = inputTuition();
					C206_CaseStudy.addTuition(tuitionList, addTuition);

				} else if (tuitionType == ADD_TIMETABLE) {
					// YenTong
					TimeTable addTime = inputTimeTable();
					C206_CaseStudy.addTimeTable(timetableList, addTime);

				} else if (tuitionType == ADD_STUDENTS) {
					// Keng Siong
					Student addStudent = inputStudent();
					C206_CaseStudy.addStudent(studentList, addStudent);


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
					C206_CaseStudy.doDeleteTuition(tuitionList);

				} else if (tuitionType == DELETE_TIMETABLE) {
					// YenTong
					C206_CaseStudy.doDelete(timetableList);

				} else if (tuitionType == DELETE_STUDENTS) {
					// Keng Siong
					C206_CaseStudy.deleteStudent(studentList);

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
		Helper.line(110, "-");

	}

	public static void setHeader(String header) {
		Helper.line(110, "-");
		System.out.println(header);
		Helper.line(110, "-");
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
	
	// Yentong
	public static String retrieveTimetable(ArrayList<TimeTable> timetableList) {
		String output = "";
		for (int i = 0; i < timetableList.size(); i++) {
			output += String.format("%s\n", timetableList.get(i).toString());
		}
		return output;
	}

	// Yentong
	public static void viewTimeTable(ArrayList<TimeTable> timetableList) {
		C206_CaseStudy.setHeader("TIMETABLE LIST");
		String output = String.format("%-5s %-10s %-13s %-13s %-10s\n", "ID", "PRICE", "START DATE", "END DATE",
				"MODE");
		output += retrieveTimetable(timetableList);
		System.out.println(output);
	}

	// Bryan
	public static String retrieveRegister(ArrayList<Register> registerList) {
		String output = "";
		for (int i = 0; i < registerList.size(); i++) {
			output += String.format("%-3s", registerList.get(i).toString());
		}
		return output;
	}

	// Bryan
	public static void viewReg(ArrayList<Register> registerList) {
		C206_CaseStudy.setHeader("REGISTRATION LIST");
		String output = String.format("%-5s %-5s %-25s %-10s %-10s \n", "NO.", "ID", "EMAIL", "STATUS", "DATE");
		output += retrieveRegister(registerList);
		System.out.println(output);
	}

	// Danish
	public static String retrieveTuition(ArrayList<Tuition> tuitionList) {
		String output = "";
		for (int i = 0; i < tuitionList.size(); i++) {
			output += String.format("%-5s", tuitionList.get(i).toString());
		}
		return output;
	}

	// Danish
	public static void viewTuition(ArrayList<Tuition> tuitionList) {
		C206_CaseStudy.setHeader("TUITION LIST");
		String output = String.format("%-15s %-15s %-15s %-15s %-15s %-10s\n", "TUITION CODE", "TITLE", "SUBJECT", "DESC",
				"DURATION", "PRE REQUISITE");
		output += retrieveTuition(tuitionList);
		System.out.println(output);
	}
	//KengSiong
	public static String retrieveStudent(ArrayList<Student> studentList) {
		String output = "";
		for (int i = 0; i < studentList.size(); i++) {
			output += String.format("%s", studentList.get(i).toString());
		}
		return output;
	}
	//KengSiong
	public static void viewStudent(ArrayList<Student> studentList) {
		C206_CaseStudy.setHeader("STUDENT LIST");
		String output = String.format("%-15s %-10s %-15s %-20s %-15s %-15s %-10s\n", "NAME", "GENDER", "MOBILE NUMBER",
				"EMAIL", "DOB", "COR", "YEAR JOINED");
		output += retrieveStudent(studentList);
		System.out.println(output);
	}

	// ================================= Option 2 Add (CRUD -
	// Create)=================================
	
	// Yentong
	public static TimeTable inputTimeTable() {
		double price = Helper.readDouble("Enter price > $");
		String startDate = Helper.readString("Enter Start Date > ");
		String endDate = Helper.readString("Enter End Date > ");
		String mode = Helper.readString("Enter Mode > ");

		Helper.line(80, "-");
		TimeTable tt = new TimeTable(TimeTable.generateId(), price, startDate, endDate, mode.toUpperCase());
		return tt;
	}

	// Yentong
	public static void addTimeTable(ArrayList<TimeTable> timetableList, TimeTable tt) {
		timetableList.add(tt);
		System.out.println("TimeTable Added!");
	}

	// Bryan
	public static Register inputRegister() {
		String email = Helper.readString("Enter email > ");
		String status = "";
		String date = Helper.readString("Enter Register Date > ");

		Helper.line(80, "-");
		Register r = new Register(Register.generateReg(), Register.generateId(), email, status, date);
		return r;
	}

	// Bryan
	public static void addRegister(ArrayList<Register> registerList, Register r) {
		registerList.add(r);
		System.out.println("Registered!");
	}

//Danish
	public static Tuition inputTuition() {
		int tuitCode = Helper.readInt("Enter tuition code > ");
		String title = Helper.readString("Enter tuition title > ");
		String subject = Helper.readString("Enter subject > ");
		String desc = Helper.readString("Enter desc > ");
		int duration = Helper.readInt("Enter duration > ");
		String prerequisite = Helper.readString("Enter Pre-requisite > ");

		Helper.line(80, "-");
		Tuition tn = new Tuition(tuitCode, title, subject, desc, duration, prerequisite);
		return tn;
	}

//Danish
	public static void addTuition(ArrayList<Tuition> tuitionList, Tuition tn) {
		tuitionList.add(tn);
		System.out.println("Tuition added");
	}
	//KengSiong
	public static Student inputStudent() {
		String name = Helper.readString("Enter Student Name: ");
		String gender = Helper.readString("Enter Gender: ");
		int mobile = Helper.readInt("Enter Mobile: ");
		String email = Helper.readString("Enter email: ");
		String DoB = Helper.readString("Enter Date of Birth: ");
		String CoR = Helper.readString("Enter country of residence: ");
		int YearJoined = Helper.readInt("Enter year Joined: ");

		Student S = new Student(name, gender, mobile, email, DoB, CoR, YearJoined);
		return S;
	}
		public static void addStudent(ArrayList<Student> studentList, Student S) {

			studentList.add(S);
			System.out.println("Student Added!");
		}


	// ================================= Option 3 Delete (CRUD -
	// Delete)=================================

	// Yentong
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

	// Yentong
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

	// Bryan
	public static boolean doFindReg(ArrayList<Register> registerList, int reg) {
		boolean isFound = false;
		for (int i = 0; i < registerList.size(); i++) {
			if (registerList.get(i).getRegNum() == reg) {
				registerList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}

	// Bryan
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

//Danish
	public static void doDeleteTuition(ArrayList<Tuition> tuitionList) {
		C206_CaseStudy.viewTuition(tuitionList);
		int tuitCode = Helper.readInt("Enter Tuition Code > ");
		Boolean isFound = doFindTuition(tuitionList, tuitCode);

		if (isFound == false) {
			System.out.println("Invalid Tuition Code");
		} else {
			System.out.println("Tuition Code (ID" + tuitCode + ") successfully deleted!");
		}
	}

//Danish
	public static boolean doFindTuition(ArrayList<Tuition> tuitionList, int tuitCode) {
		boolean isFound = false;
		for (int i = 0; i < tuitionList.size(); i++) {
			if (tuitionList.get(i).tuitCode() == tuitCode) {
				tuitionList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}
	//KengSiong
	public static Boolean doFindStud(ArrayList<Student> studentList, String j) {
		boolean isFound = false;
		for (int i = 0; i < studentList.size(); i++) {
			if (studentList.get(i).getName() == j) {
				studentList.remove(i);
				isFound = true;
			}
		}
		return isFound;
	}


	//KengSiong
	public static void deleteStudent(ArrayList<Student> studentList) {
		String name = Helper.readString("Enter name to delete: ");

		for (int i = 0; i <= studentList.size(); i++) {
			if (studentList.get(i).getName() == name) {

				studentList.remove(i);
				System.out.println("");
			} else {
				System.out.println("Name not found.");
			}
		}

	}
}
