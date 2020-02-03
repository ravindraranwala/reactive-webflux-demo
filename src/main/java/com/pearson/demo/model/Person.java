package com.pearson.demo.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Represents a Person entity in our system. A {@link Person} has a unique id
 * value, name, degree and a job respectively.
 * 
 * @author ravindra
 *
 */
public final class Person {
	private final int id;
	private final String name;
	private final String education;
	private final String career;

	/**
	 * Constructs a Person instance in the system.
	 * 
	 * @param id        unique identifier value
	 * @param name      Name of the Person
	 * @param education highest degree this person holds
	 * @param career    The job this person does
	 */
	@JsonCreator
	public Person(@JsonProperty("id") int id, @JsonProperty("name") String name,
			@JsonProperty("education") String education, @JsonProperty("career") String career) {
		super();
		this.id = id;
		this.name = name;
		this.education = education;
		this.career = career;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEducation() {
		return education;
	}

	public String getCareer() {
		return career;
	}
}
