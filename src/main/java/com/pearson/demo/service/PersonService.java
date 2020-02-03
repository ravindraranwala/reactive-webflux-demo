package com.pearson.demo.service;

import com.pearson.demo.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class defines all the contracts associated with a person. For an
 * instance it is responsible for creating a {@link Person}, fetching the
 * {@link Person} etc.
 * 
 * @author ravindra
 *
 */
public interface PersonService {
	/**
	 * Fetches a person for a given ID if exists.
	 * 
	 * @param id person identifier value.
	 * @return Person instance with the given ID value.
	 */
	public Mono<Person> getPersonById(int id);

	/**
	 * Fetches all the people in the system.
	 * 
	 * @return All the people in the system.
	 */
	public Flux<Person> getAllPeople();
}
