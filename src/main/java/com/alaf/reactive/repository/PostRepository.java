package com.alaf.reactive.repository;

import org.springframework.data.r2dbc.repository.Modifying;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.alaf.reactive.model.Post;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PostRepository extends R2dbcRepository<Post, Integer> {
	
	@Query(value = "SELECT * FROM post WHERE id BETWEEN :min AND :max")
	Flux<Post> findPostInRange(@Param("min") int min, @Param("max") int max);

	@Modifying
	@Query(value = "INSERT INTO post (Id, title, body, userid) VALUES (:#{#post.Id}, :#{#post.title}, :#{#post.body}, :#{#post.userid} )")
	Mono<Post> save(final Post post);
}
