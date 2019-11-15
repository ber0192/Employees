package sk.employees;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/getByGender/{gender}")
	public List<Employee> getByGender(@PathVariable String gender) {
		return Program.getEmployeesByGender(Controller.createEmployees(),
				gender.equals("male") ? Gender.male : Gender.female);
	}

	@RequestMapping("/sortByAge")
	public List<Employee> sortByAge() {
		return Program.sortEmployeesByAge(Controller.createEmployees());
	}

	@RequestMapping("/getByCity/{city}")
	public List<Employee> getByCity(@PathVariable String city) {
		return Program.getEmployeesByCity(Controller.createEmployees(), city);
	}

	@RequestMapping("/getActive")
	public List<Employee> getActive() {
		return Program.getActiveEmployees(Controller.createEmployees());
	}

	public static List<Employee> createEmployees() {
		City bratislava = new City("BA", "Bratislava");
		City kosice = new City("KE", "Košice");
		City praha = new City("PRG", "Praha");
		State slovakia = new State("SVK", "Slovensko");
		State czech_republic = new State("CZE", "Česká republika");
		List<Employee> employees = new ArrayList<Employee>();
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
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		employees.add(emp4);
		employees.add(emp5);
		return employees;
	}

}
