import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C206_CaseStudyTest {
	private TimeTable tt;
	private ArrayList<TimeTable> timetableList;

	@Before
	public void setUp() throws Exception {
		timetableList = new ArrayList<TimeTable>();
		tt = new TimeTable(TimeTable.generateId(), 4.2, "20/04/2021", "20/09/2021", "ONLINE");
	}

	@After
	public void tearDown() throws Exception {
		timetableList = null;
		tt = null;
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
		testOutput = String.format("%-5s $%-9.2f %-13s %-13s %-10s", 1, 4.2, "20/04/2021",
				"20/09/2021", "ONLINE");

		assertEquals("Test that viewTimeTable", testOutput,all);
	}

	@Test
	public void addTimeTable() {
		// TimeTable list is not null, so that can add a new item - boundary
		assertNotNull("Test if there is valid Timetable arraylist to add to", timetableList);

		// Given an empty list, after adding 1 item, the size of the list is 1 - normal
		// The item just added is as same as the first item of the list
		C206_CaseStudy.addTimeTable(timetableList, tt);
		assertEquals("Test that TimeTable arraylist size is 1", 1, timetableList.size());
		assertSame("Test that Chromebook is added", tt, timetableList.get(0));
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
		isFound = C206_CaseStudy.doFind(timetableList,  TimeTable.generateId());
		assertFalse("Test if non-existing Timetable is found - false?", isFound);
	}

//	@Test
//	public void c206_test() {
//		// fail("Not yet implemented");
//		assertTrue("C206_CaseStudy_SampleTest ", true);
//	}
}
