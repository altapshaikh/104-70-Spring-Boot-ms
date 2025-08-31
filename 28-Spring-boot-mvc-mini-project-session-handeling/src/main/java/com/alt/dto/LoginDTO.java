package com.alt.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class LoginDTO {

	@NotBlank(message = "email is requied")
	@Email(message = "invalid email")
	private String email;

	@Size(min = 6, message = "Password must be at least 6 char long")
	private String password;
}
