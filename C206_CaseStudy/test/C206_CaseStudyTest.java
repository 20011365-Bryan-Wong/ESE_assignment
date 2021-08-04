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

	private Tuition t;
	private ArrayList<Tuition> tuitionList;

	@Before
	public void setUp() throws Exception {
		timetableList = new ArrayList<TimeTable>();
		tt = new TimeTable(TimeTable.generateId(), 4.2, "20/04/2021", "20/09/2021", "ONLINE");

		registerList = new ArrayList<Register>();
		r = new Register(Register.generateReg(), Register.generateId(), "20011365@myrp.edu.sg", "Pending",
				"03/08/2021");

		tuitionList = new ArrayList<Tuition>();
		t = new Tuition(Tuition.generateCode()-1, "001", "Biology 2", "biology", 2, "Biology level 1");
	}

	@After
	public void tearDown() throws Exception {
		timetableList = null;
		tt = null;

		registerList = null;
		r = null;

		tuitionList = null;
		t = null;
	}

	@Test
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
		testOutput = String.format("%-5s $%-9.2f %-13s %-13s %-10s\n", 2, 4.2, "20/04/2021", "20/09/2021", "ONLINE");

		assertEquals("Test that viewTimeTable", testOutput, all);
	}

	@Test
	public void addTimeTable() {
		// TimeTable list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Timetable arraylist to add to", timetableList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTimeTable(timetableList, tt);
		assertEquals("Test that TimeTable arraylist size is 1", 1, timetableList.size());
		assertSame("Test that a TimeTable is added", tt, timetableList.get(0));
	}

	public void doDelete() {
		// Boundary
		assertNotNull("Test if there is valid TimeTable arraylist to add to", timetableList);
		C206_CaseStudy.addTimeTable(timetableList, tt);

		// Error
		Boolean isFound = C206_CaseStudy.doFind(timetableList, TimeTable.generateId());
		assertFalse("Test if available TimeTable is found -false?", isFound);

		// Normal
		C206_CaseStudy.addTimeTable(timetableList, tt);
		isFound = C206_CaseStudy.doFind(timetableList, TimeTable.generateId());
		assertTrue("Test if TimeTable is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFind(timetableList, TimeTable.generateId());
		assertFalse("Test if non-existing Timetable is found - false?", isFound);
	}

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
		testOutput = String.format("%-5d %-5s %-25s %-10s %-10s\n", Register.generateReg(), Register.generateId(),
				"20011365@myrp.edu.sg", "Pending", "03/08/2021");

		assertEquals("Test that viewTimeTable", testOutput, all);
	}

	public void addReg() {
		// Registration list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Registration arraylist to add to", registerList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTimeTable(timetableList, tt);
		assertEquals("Test that registerList arraylist size is 1", 1, registerList.size());
		assertSame("Test that a Register is added", tt, registerList.get(0));
	}

	public void doDeleteReg() {
		// Boundary
		assertNotNull("Test if there is valid Registration arraylist to add to", registerList);
		C206_CaseStudy.addTimeTable(timetableList, tt);

		// Error
		Boolean isFound = C206_CaseStudy.doFindReg(registerList, Register.generateReg());
		assertFalse("Test if available Registration is found -false?", isFound);

		// Normal
		C206_CaseStudy.addRegister(registerList, r);
		isFound = C206_CaseStudy.doFindReg(registerList, Register.generateReg());
		assertTrue("Test if Registration is found- true", isFound);

		// Error
		isFound = C206_CaseStudy.doFindReg(registerList, Register.generateReg());
		assertFalse("Test if non-existing Registration is found - false?", isFound);
	}

	@Test
	public void retrieveTuition() {
		// Danish - Take the format from retrieveReg()
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
		testOutput = String.format("%-25d %-15s %-15s %-16s %-22s %-10s", Tuition.generateCode() - 2, t.title(),
				t.subject(), t.desc(), t.duration(), t.prerequisite());

		assertEquals("Test that viewTuition", testOutput, all);
	}

	@Test
	public void addTuition() {
		// Danish - Take the format from addReg()
		assertNotNull("Test if there is valid Tuition arraylist to add to", tuitionList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTuition(tuitionList, t);
		assertEquals("Test that tuitionList arraylist size is 1", 1, tuitionList.size());
		assertSame("Test that a Tuition is added", t, tuitionList.get(0));
	}

	@Test
	public void doDeleteTuition() {
		// Danish - Take the format from doDeleteReg()
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

//	@Test
//	public void c206_test() {
//		// fail("Not yet implemented");
//		assertTrue("C206_CaseStudy_SampleTest ", true);
//	}
}
