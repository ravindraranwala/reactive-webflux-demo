package com.pearson.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.pearson.demo.model.Person;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PersonServiceImpl implements PersonService {
	private static final Logger LOGGER = LoggerFactory.getLogger(PersonServiceImpl.class);

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Mono<Person> getPersonById(int id) {
		LOGGER.debug(String.format("Fetching Person information for ID: ", id));
		return WebClient.create("http://www.mocky.io/v2/5e378a773100000f00d37ae2").get().retrieve()
				.bodyToMono(Person.class);
	}

	@Override
	public Flux<Person> getAllPeople() {
		return WebClient.create("http://www.mocky.io/v2/5e378e123100006c00d37af2").get().retrieve()
				.bodyToFlux(Person.class);
	}

}
