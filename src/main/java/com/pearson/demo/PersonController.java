package com.pearson.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pearson.demo.model.Person;
import com.pearson.demo.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/person")
public class PersonController {
	private final PersonService personService;

	public PersonController(PersonService personService) {
		super();
		this.personService = personService;
	}

	@GetMapping("/{id}")
	Mono<Person> findById(@PathVariable int id) {
		return personService.getPersonById(id);
	}

	@GetMapping()
	Flux<Person> getAllPeople() {
		return personService.getAllPeople();
	}
}
