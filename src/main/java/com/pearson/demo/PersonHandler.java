package com.pearson.demo;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;

import com.pearson.demo.model.Person;
import com.pearson.demo.service.PersonService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PersonHandler {
	private final PersonService personService;

	public PersonHandler(PersonService personService) {
		super();
		this.personService = personService;
	}

	public Mono<ServerResponse> findById(ServerRequest request) {
		final int personId = Integer.parseInt(request.pathVariable("id"));
		final Mono<Person> personMono = personService.getPersonById(personId);

		final Mono<ServerResponse> notFound = ServerResponse.notFound().build();
		return personMono.flatMap(p -> ServerResponse.ok().body(fromPublisher(personMono, Person.class)))
				.switchIfEmpty(notFound);
	}

	public Mono<ServerResponse> getAllPeople(ServerRequest request) {
		final Flux<Person> people = personService.getAllPeople();
		return ServerResponse.ok().body(fromPublisher(people, Person.class));
	}
}
