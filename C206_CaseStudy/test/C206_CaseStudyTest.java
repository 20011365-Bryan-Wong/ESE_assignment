import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private TimeTable tt;
	private ArrayList<TimeTable> timetableList;

	private Register r;
	private ArrayList<Register> registerList;

	private Student s;
	private ArrayList<Student> studentList;

	private Tuition t;
	private ArrayList<Tuition> tuitionList;

	@Before
	public void setUp() throws Exception {
		timetableList = new ArrayList<TimeTable>();
		tt = new TimeTable(TimeTable.generateId() - 1, 4.2, "20/04/2021", "20/09/2021", "ONLINE");

		registerList = new ArrayList<Register>();
		r = new Register(Register.generateReg(), Register.generateId(), "20011365@myrp.edu.sg", "Pending",
				"03/08/2021");
		studentList = new ArrayList<Student>();
		s = new Student("keng Siong", "M", 98765432, "20011945@rp.edu.sg", "14/12/2002", "Singapore", 2021);

		tuitionList = new ArrayList<Tuition>();
		t = new Tuition(Tuition.generateCode() - 1, "001", "Biology 2", "biology", 2, "Biology level 1");
	}

	@After
	public void tearDown() throws Exception {
		timetableList = null;
		tt = null;

		registerList = null;
		r = null;

		tuitionList = null;
		t = null;

		studentList = null;
		s = null;
	}

	@Test
	// Yentong
	public void retrieveTimetable() {
		// Test if list is not null but empty -boundary
		assertNotNull("Test if there is valid Timetable arraylist to retrieve", timetableList);

		// Test if the list retrieved is empty - boundary
		String all = C206_CaseStudy.retrieveTimetable(timetableList);
		String testOutput = "";
		assertEquals("Check that viewTimeTablelist", testOutput, all);

		// Given an empty list, after adding 1 item, test if the size of the list is 1 -
		// normal
		C206_CaseStudy.addTimeTable(timetableList, tt);
		assertEquals("Check that TimeTableList arraylist size is 1", 1, timetableList.size());

		// Test if the expected output string same as the list of timetable retrieved
		all = C206_CaseStudy.retrieveTimetable(timetableList);
		testOutput = String.format("%-5s $%-9.2f %-13s %-13s %-10s %-10s\n", 2, 4.2, "20/04/2021", "20/09/2021",
				"ONLINE", "null");

		assertEquals("Test that viewTimeTable", testOutput, all);
	}

	@Test
	// Yentong
	public void addTimeTable() {
		// TimeTable list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Timetable arraylist to add to", timetableList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTimeTable(timetableList, tt);
		assertEquals("Test that TimeTable arraylist size is 1", 1, timetableList.size());
		assertSame("Test that a TimeTable is added", tt, timetableList.get(0));
	}

	@Test
	// Yentong
	public void doDelete() {
		// Boundary
		assertNotNull("Test if there is valid TimeTable arraylist to add to", timetableList);
		C206_CaseStudy.addTimeTable(timetableList, tt);

		// Error
		Boolean isFound = C206_CaseStudy.doFind(timetableList, TimeTable.generateId());
		assertFalse("Test if available TimeTable is found -false?", isFound);

		// Normal
		C206_CaseStudy.addTimeTable(timetableList, tt);
		isFound = C206_CaseStudy.doFind(timetableList, tt.getId());
		assertTrue("Test if TimeTable is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFind(timetableList, TimeTable.generateId());
		assertFalse("Test if non-existing Timetable is found - false?", isFound);
	}

	@Test
	// Yentong
	public void doUpdate() {
		// Boundary
		assertNotNull("Test if there is valid TimeTable arraylist to add to", timetableList);
		C206_CaseStudy.addTimeTable(timetableList, tt);

		// Error
		Boolean isFound = C206_CaseStudy.doFindDate(timetableList, tt.getStartDate(), tt.getEndDate());
		assertFalse("Test if available TimeTable is found -false?", isFound);

		// Normal
		C206_CaseStudy.addTimeTable(timetableList, tt);
		isFound = C206_CaseStudy.doFindDate(timetableList, tt.getStartDate(), tt.getEndDate());
		assertTrue("Test if TimeTable is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFindDate(timetableList, tt.getStartDate(), tt.getEndDate());
		assertFalse("Test if non-existing Timetable is found - false?", isFound);

	}

	@Test
	// Bryan
	public void retrieveReg() {
		// Test if list is not null but empty -boundary
		assertNotNull("Test if there is valid Registration arraylist to retrieve", registerList);

		// Test if the list retrieved is empty - boundary
		String all = C206_CaseStudy.retrieveRegister(registerList);
		String testOutput = "";
		assertEquals("Check that viewRegisterlist", testOutput, all);

		// Given an empty list, after adding 1 item, test if the size of the list is 1 -
		// normal
		C206_CaseStudy.addRegister(registerList, r);
		assertEquals("Check that Registration arraylist size is 1", 1, registerList.size());

		// Test if the expected output string same as the list of timetable retrieved
		all = C206_CaseStudy.retrieveRegister(registerList);
		testOutput = String.format("%-5d %-5s %-25s %-10s %-10s", r.getRegNum(), r.getId(), "20011365@myrp.edu.sg",
				"Pending", "03/08/2021");

		assertEquals("Test that viewTimeTable", testOutput, all);
	}

	@Test
	// Bryan
	public void addReg() {
		// Registration list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Registration arraylist to add to", registerList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addRegister(registerList, r);
		assertEquals("Test that registerList arraylist size is 1", 1, registerList.size());
		assertSame("Test that a Register is added", r, registerList.get(0));
	}

	@Test
	// Bryan
	public void doDeleteReg() {
		// Boundary
		assertNotNull("Test if there is valid Register arraylist to add to", registerList);
		C206_CaseStudy.addRegister(registerList, r);

		// Error
		Boolean isFound = C206_CaseStudy.doFindReg(registerList, Register.generateReg());
		assertFalse("Test if available Register is found -false?", isFound);

		// Normal
		C206_CaseStudy.addRegister(registerList, r);
		isFound = C206_CaseStudy.doFindReg(registerList, r.getId());
		assertTrue("Test if Register is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFindReg(registerList, Register.generateReg());
		assertFalse("Test if non-existing Register is found - false?", isFound);
	}

	@Test
	public void retrieveTuition() {
		// Danish
		assertNotNull("Test if there is valid Tuition arraylist to retrieve", tuitionList);

		// Test if the list retrieved is empty - boundary
		String all = C206_CaseStudy.retrieveTuition(tuitionList);
		String testOutput = "";
		assertEquals("Check that viewTuitionlist", testOutput, all);

		// Given an empty list, after adding 1 item, test if the size of the list is 1 -
		// normal
		C206_CaseStudy.addTuition(tuitionList, t);
		assertEquals("Check that Tuition arraylist size is 1", 1, tuitionList.size());

		// Test if the expected output string same as the list of timetable retrieved
		all = C206_CaseStudy.retrieveTuition(tuitionList);
		testOutput = String.format("%-15d %-15s %-15s %-15s %-15s %-10s", Tuition.generateCode() - 2, t.title(),
				t.subject(), t.desc(), t.duration(), t.prerequisite());

		assertEquals("Test that viewTuition", testOutput, all);
	}

	@Test
	public void addTuition() {
		// Danish
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTuition(tuitionList, t);
		assertEquals("Test that tuitionList arraylist size is 1", 1, tuitionList.size());
		assertSame("Test that a Tuition is added", t, tuitionList.get(0));
	}

	@Test
	public void doDeleteTuition() {
		// Danish
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);
		C206_CaseStudy.addTuition(tuitionList, t);

		// Error
		Boolean isFound = C206_CaseStudy.doFindTuition(tuitionList, Tuition.generateCode());
		assertFalse("Test if available Tuition is found -false?", isFound);

		// Normal
		C206_CaseStudy.addTuition(tuitionList, t);
		isFound = C206_CaseStudy.doFindTuition(tuitionList, t.tuitCode());
		assertTrue("Test if Tuition is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFindTuition(tuitionList, Tuition.generateCode());
		assertFalse("Test if non-existing Tuition is found - false?", isFound);
	}

	// KengSiong
	@Test
	public void retrieveStud() {
		// Test if list is not null but empty -boundary
		assertNotNull("Test if there is valid Student arraylist to retrieve", studentList);

		// Test if the list retrieved is empty - boundary
		String all = C206_CaseStudy.retrieveStudent(studentList);
		String testOutput = "";
		assertEquals("Check that viewStudentlist", testOutput, all);

		// Given an empty list, after adding 1 item, test if the size of the list is 1 -
		// normal
		C206_CaseStudy.addStudent(studentList, s);
		assertEquals("Check that Student arraylist size is 1", 1, studentList.size());

		// Test if the expected output string same as the list of timetable retrieved
		all = C206_CaseStudy.retrieveStudent(studentList);
		testOutput = String.format("%-15s %-10s %-15s %-20s %-15s %-15s %-10s", "keng Siong", "M", 98765432,
				"20011945@rp.edu.sg", "14/12/2002", "Singapore", 2021);

		assertEquals("Test that viewStudent", testOutput, all);
	}

	// KengSiong
	@Test
	public void addStud() {
		// Registration list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addStudent(studentList, s);
		assertEquals("Test that StudentList arraylist size is 1", 1, studentList.size());
		assertSame("Test that a Student is added", s, studentList.get(0));
	}

	// KengSiong
	@Test
	public void doDeleteStud() {
		// Boundary
		assertNotNull("Test if there is valid Student arraylist to add to", studentList);
		C206_CaseStudy.addStudent(studentList, s);

		// Error
		Boolean isFound = C206_CaseStudy.doFindStud(studentList, Student.generateStudent());
		assertFalse("Test if available Register is found -false?", isFound);

		// Normal
		C206_CaseStudy.addStudent(studentList, s);
		isFound = C206_CaseStudy.doFindStud(studentList, s.getName());
		assertTrue("Test if Student is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFindStud(studentList, Student.generateStudent());
		assertFalse("Test if non-existing Student is found - false?", isFound);
	}

//	@Test
//	public void c206_test() {
//		// fail("Not yet implemented");
//		assertTrue("C206_CaseStudy_SampleTest ", true);
//	}
}
