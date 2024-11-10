package com.alaf.reactive.router;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.alaf.reactive.handler.PostHandler;
import com.alaf.reactive.handler.PostStreamHandler;

@Configuration
public class RouterConfig {

    @Autowired
    private PostHandler handler;

    @Autowired
    private PostStreamHandler streamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions.route()
                .GET("/router/posts", handler::getPosts)
                .GET("/router/posts/stream/{maxIndex}", streamHandler::getPostStream)
                .GET("/router/post/{id}", handler::findPost)
                .build();
    }
}