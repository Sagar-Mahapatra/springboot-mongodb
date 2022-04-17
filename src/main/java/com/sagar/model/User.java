package com.sagar.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "user")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {

	@Id
	private String id;
	@Field("name")
	@NotBlank
	private String username;
	@Field("city")
	@NotBlank
	private String city;
	@Field("email")
	@NotNull(message = "email must not be null")
	@Size(min = 10, message = "email must be min 10 chars")
	@Email
	private String emailId;

}
