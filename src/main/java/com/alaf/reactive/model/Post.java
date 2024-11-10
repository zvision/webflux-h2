package com.alaf.reactive.model;


import org.springframework.data.annotation.Id;

import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Table
@AllArgsConstructor
@NoArgsConstructor
public class Post {
	
	@Id
	private Integer Id;
	private String title;
	private String body;
	private Integer userid;

	
}
