package sk.employees;

import java.util.Objects;

public class State {

	private String code;
	private String name;

	public String getName() {
		return this.name;
	}

	public String getCode() {
		return this.code;
	}

	public State(String code, String name) {
		Objects.requireNonNull(code, "code must not be null");
		Objects.requireNonNull(name, "name must not be null");
		this.code = code;
		this.name = name;
	}
}
