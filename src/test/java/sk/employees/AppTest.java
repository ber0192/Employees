package sk.employees;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AppTest {

	List<Employee> employees;

	@Before
	public void beforeTests() {
		City bratislava = new City("BA", "Bratislava");
		City kosice = new City("KE", "Košice");
		City praha = new City("PRG", "Praha");
		State slovakia = new State("SVK", "Slovensko");
		State czech_republic = new State("CZE", "Česká republika");
		employees = new ArrayList<Employee>();
		Employee emp1 = new Employee(new Calendar.Builder().setDate(2020, 1, 1).build().getTime(), null, 30, 1, "Peter",
				"Komaš", new Calendar.Builder().setDate(1989, 6, 20).build().getTime(), Gender.male,
				new Address("Riazanská 5", "82432", bratislava, slovakia));
		Employee emp2 = new Employee(new Calendar.Builder().setDate(2012, 2, 21).build().getTime(),
				new Calendar.Builder().setDate(2017, 2, 21).build().getTime(), 38, 2, "Zuzana", "Skoncová",
				new Calendar.Builder().setDate(1981, 9, 5).build().getTime(), Gender.female,
				new Address("Riazanská 38", "82432", bratislava, slovakia));
		Employee emp3 = new Employee(new Calendar.Builder().setDate(2012, 2, 21).build().getTime(), null, 45, 3, "Ján",
				"Demjan", new Calendar.Builder().setDate(1974, 3, 19).build().getTime(), Gender.male,
				new Address("Štúrova 11", "82101", kosice, slovakia));
		Employee emp4 = new Employee(new Calendar.Builder().setDate(2012, 2, 21).build().getTime(),
				new Calendar.Builder().setDate(2020, 1, 31).build().getTime(), 27, 4, "Aneta", "Opletalová",
				new Calendar.Builder().setDate(1992, 11, 10).build().getTime(), Gender.female,
				new Address("Olšanská 15", "09231", praha, czech_republic));
		Employee emp5 = new Employee(new Calendar.Builder().setDate(2010, 6, 16).build().getTime(), null, 41, 5,
				"Andrej", "Bandor", new Calendar.Builder().setDate(1978, 16, 6).build().getTime(), Gender.male,
				new Address("Čimická 7", "09232", praha, czech_republic));

		this.employees.add(emp1);
		this.employees.add(emp2);
		this.employees.add(emp3);
		this.employees.add(emp4);
		this.employees.add(emp5);
	}

	@Test
	public void testGetEmployeesByGender() {
		List<Employee> expected = new ArrayList<Employee>();
		expected.add(employees.get(0));
		expected.add(employees.get(2));
		expected.add(employees.get(4));
		List<Employee> result = Program.getEmployeesByGender(employees, Gender.male);
		assertEquals(expected, result);
	}

	@Test
	public void testSortEmployeesByAge() {
		List<Employee> expected = new ArrayList<Employee>();
		expected.add(employees.get(3));
		expected.add(employees.get(0));
		expected.add(employees.get(1));
		expected.add(employees.get(4));
		expected.add(employees.get(2));
		List<Employee> result = Program.sortEmployeesByAge(employees);
		assertEquals(expected, result);
	}

	@Test
	public void testGetEmployeesByCity() {
		List<Employee> expected = new ArrayList<Employee>();
		expected.add(employees.get(0));
		expected.add(employees.get(1));
		List<Employee> result = Program.getEmployeesByCity(employees, "BA");
		assertEquals(expected, result);
	}

	@Test
	public void testGetActiveEmployees() {
		List<Employee> expected = new ArrayList<Employee>();
		expected.add(employees.get(2));
		expected.add(employees.get(3));
		expected.add(employees.get(4));
		List<Employee> result = Program.getActiveEmployees(employees);
		assertEquals(expected, result);
	}

	@Test
	public void testPrintEmployees() {
		PrintStream standard = System.out;
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Program.printEmployees(employees);
		System.setOut(standard);
		Program.printEmployees(employees);
		String expectedOutput = "Slovensko\n---- Bratislava\n---- ---- Peter Komaš\n"
				+ "---- ---- Zuzana Skoncová\n---- Košice\n---- ---- Ján Demjan\nČeská republika\n---- Praha\n"
				+ "---- ---- Aneta Opletalová\n---- ---- Andrej Bandor\n";
		assertEquals(expectedOutput, outContent.toString());
	}
}
