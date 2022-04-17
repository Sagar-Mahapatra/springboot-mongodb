package com.sagar.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	private Integer id;
	private String name;
	private String city;
	private String email;

}
