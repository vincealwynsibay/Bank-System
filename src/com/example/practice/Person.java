package com.example.practice;
import java.util.Objects;

public class Person {
	private String name;
	private String occupation;


	public Person(String name, String occupation) {
		this.name = name;
		this.occupation = occupation;

	}

	public String getName() {
		return name;
	}

	public String getOccupation() {
		return occupation;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return Objects.equals(name, person.name) &&
				Objects.equals(occupation, person.occupation);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, occupation);
	}
}
