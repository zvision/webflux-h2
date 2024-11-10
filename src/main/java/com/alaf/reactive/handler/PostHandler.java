package com.alaf.reactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alaf.reactive.model.Post;
import com.alaf.reactive.repository.PostRepository;

import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostHandler {

	@Autowired
	private PostRepository repository;
	
	public Mono<ServerResponse> getPosts(ServerRequest request) {
		Flux<Post> postFlux = repository.findAll();
		return ServerResponse.ok().body(postFlux, Post.class);
	}
	
	public Mono<ServerResponse> findPost(ServerRequest request) {
		int postId = Integer.valueOf(request.pathVariable("id"));
		Mono<Post> postMono = repository.findById(postId);
		return ServerResponse.ok().body(postMono, Post.class);
	}

}
