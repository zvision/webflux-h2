package com.alaf.reactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alaf.reactive.model.Post;
import com.alaf.reactive.repository.PostRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PostStreamHandler {

	@Autowired
	private PostRepository repository;

	public Mono<ServerResponse> getPostStream(ServerRequest request) {
		int maxIndex = Integer.parseInt(request.pathVariable("maxIndex"));
		Flux<Post> postsStream = repository.findPostInRange(0, maxIndex);
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(postsStream, Post.class);
	}

}
