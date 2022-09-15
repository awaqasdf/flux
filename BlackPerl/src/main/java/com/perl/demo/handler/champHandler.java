package com.perl.demo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.perl.demo.model.Champ;
import com.perl.demo.repository.champRepository;
import com.perl.demo.service.champService;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class champHandler {
	@Autowired
	champService champservice;
	 public Mono<ServerResponse> getAllStatusCode(ServerRequest request) {
		 int id =Integer.parseInt(request.pathVariable("id"));
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
				.body(champservice.findById(), Champ.class);
		   
		  }
	 
	 public Mono<ServerResponse> saveStatusCode(ServerRequest request){
		 Mono<Champ> status=request.bodyToMono(Champ.class);
		return status.flatMap(abcd->ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
								.body(champservice.save(abcd), Champ.class)) ;
		 
	 }
	 
}


