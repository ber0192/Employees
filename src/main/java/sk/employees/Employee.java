package sk.employees;

import java.util.Date;
import java.util.Objects;

public class Employee {
	private Date employeeFrom;
	private Date employeeTo;
	private int age;
	private int employeeId;
	private String name;
	private String surname;
	private Date dateOfBirth;
	private Gender gender;
	private Address contact_address;

	public Gender getGender() {
		return this.gender;
	}

	public String getName() {
		return this.name;
	}

	public String getSurname() {
		return this.surname;
	}

	public int getAge() {
		return this.age;
	}

	public Address getAddress() {
		return this.contact_address;
	}

	public String getCity() {
		return this.contact_address.getCity().getName();
	}

	public String getState() {
		return this.contact_address.getState().getName();
	}

	public Date getEmployeeFrom() {
		return this.employeeFrom;
	}

	public Date getEmployeeTo() {
		return this.employeeTo;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public Date getDateOfBirth() {
		return this.dateOfBirth;
	}

	public Employee(Date employeeFrom, Date employeeTo, int age, int employeeId, String name, String surname,
					Date dateOfBirth, Gender gender, Address address) {
		Objects.requireNonNull(employeeId, "employeeid must not be null");
		Objects.requireNonNull(name, "name must not be null");
		Objects.requireNonNull(surname, "surname must not be null");
		Objects.requireNonNull(dateOfBirth, "dateOfBirth must not be null");
		this.employeeFrom = employeeFrom;
		this.employeeTo = employeeTo;
		this.age = age;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.contact_address = address;
	}
}
