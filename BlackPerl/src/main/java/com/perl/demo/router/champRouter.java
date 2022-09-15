package com.perl.demo.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perl.demo.handler.champHandler;

@Configuration
public class champRouter {	
	 
	@Bean
	public RouterFunction root(champHandler champhandler) {
		return RouterFunctions.route()
		  .GET("/champ/{id}", RequestPredicates.accept(MediaType.TEXT_PLAIN), champhandler::getAllStatusCode)
		  .POST("/save", RequestPredicates.contentType(MediaType.APPLICATION_JSON), champhandler::saveStatusCode)
		  .build();		
	}

	
}
