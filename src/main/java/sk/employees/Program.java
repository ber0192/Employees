package sk.employees;

import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Program {

	public static List<Employee> getEmployeesByGender(List<Employee> employees, Gender gender) {
		employees = employees.stream().filter(e -> e.getGender().equals(gender)).collect(Collectors.toList());
		return employees;
	}

	public static List<Employee> sortEmployeesByAge(List<Employee> employees) {
		employees = employees.stream().sorted(Comparator.comparing(Employee::getAge)).collect(Collectors.toList());
		return employees;
	}

	public static List<Employee> getEmployeesByCity(List<Employee> employees, String cityCode) {
		employees = employees.stream().filter(e -> e.getAddress().getCity().getCode().equals(cityCode))
				.collect(Collectors.toList());
		return employees;
	}

	public static List<Employee> getActiveEmployees(List<Employee> employees) {
		employees = employees.stream()
				.filter(e -> (e.getEmployeeTo() != null && e.getEmployeeTo().compareTo(new Date()) > 0
						|| e.getEmployeeTo() == null)
						&& (e.getEmployeeFrom() != null && e.getEmployeeFrom().compareTo(new Date()) <= 0))
				.collect(Collectors.toList());
		return employees;
	}

	public static void printEmployees(List<Employee> employees) {
		Map<String, List<Employee>> emp = employees.stream().collect(Collectors.groupingBy(Employee::getCity));
		String state = "";
		Map<String, List<Employee>> empSorted = new TreeMap<String, List<Employee>>(emp);

		for (Map.Entry<String, List<Employee>> entry : empSorted.entrySet()) {
			Employee empl = employees.parallelStream().filter(employee -> entry.getKey().equals(employee.getCity()))
					.findAny().orElse(null);
			if (empl != null && state != empl.getState()) {
				state = empl.getState();
				System.out.print(state + "\n");
			}

			System.out.print("---- " + entry.getKey() + "\n");
			for (Employee value : entry.getValue()) {
				System.out.print("---- ---- " + value.getName() + " " + value.getSurname() + "\n");
			}
		}

	}

	public static void main(String[] args) {
		SpringApplication.run(Program.class, args);
	}
}
