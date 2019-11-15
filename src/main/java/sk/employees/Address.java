package sk.employees;

import java.util.Objects;

public class Address {
	private String street;
	private String zip;
	private City city;
	private State state;
	
	public String getZip() {
		return this.zip;
	}
	
	public City getCity() {
		return this.city;
	}
	
	public State getState() {
		return this.state;
	}
	
	public String getStreet() {
		return this.street;
	}
	
	public Address(String street, String zip, City city, State state) {
		Objects.requireNonNull(street,"street must not be null");
		Objects.requireNonNull(zip,"zip must not be null");
		this.street = street;
		this.zip = zip;
		this.city = city;
		this.state = state;
	}
}
