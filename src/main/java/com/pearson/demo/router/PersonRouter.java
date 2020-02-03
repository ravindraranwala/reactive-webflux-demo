package com.pearson.demo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.http.MediaType.APPLICATION_JSON;

import com.pearson.demo.PersonHandler;

@Configuration
public class PersonRouter {
	@Bean
	public RouterFunction<ServerResponse> route(PersonHandler personHandler) {
		return RouterFunctions.route(GET("/people/{id}").and(accept(APPLICATION_JSON)), personHandler::findById)
				.andRoute(GET("/people").and(accept(APPLICATION_JSON)), personHandler::getAllPeople);
	}
}
