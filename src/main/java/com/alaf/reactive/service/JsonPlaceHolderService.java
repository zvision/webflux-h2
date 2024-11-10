package com.alaf.reactive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.alaf.reactive.model.Post;
import com.alaf.reactive.repository.PostRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class JsonPlaceHolderService {

	private  String url = "https://jsonplaceholder.typicode.com/posts";
		
	@Autowired
	private PostRepository repository;

	
	public void loadPosts() {
		fetchPosts().getBody()
				.forEach(a -> repository.save(a).thenMany(repository.findAll()).subscribe(
						(data) -> log.info("post: " + data), (err) -> log.error("error: " + err),
						() -> log.info("initialization is done...")));
	}
	
	private ResponseEntity<List<Post>> fetchPosts() {
		
		WebClient.Builder builder = WebClient.builder();
		
		ResponseEntity<List<Post>> postList = builder.build()
				.get()
				.uri(url)
				.retrieve()
				.toEntity(new ParameterizedTypeReference<List<Post>>(){})
				.block();
		return postList;
	}

	
	
	
	/**
	 * The traditional way using RestTemplate
	 *  
	 
	 @Autowired
	 private RestTemplete restTemplete;
	 
	 public ResponseEntity<List<Post>> getPosts() {
		ResponseEntity<List<Post>> exchange = restTemplete.exchange(url, HttpMethod.GET, null,
				new ParameterizedTypeReference<List<Post>>() {
				});
		return exchange;
	}
	 /
	 */
}
