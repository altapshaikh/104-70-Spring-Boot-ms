package com.alt.beans;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;

@Data
@JsonInclude(value = Include.NON_NULL)
public class EmployeeDTO {
	@JsonProperty
	private int id;
	@JsonProperty
	private String name;
	@JsonProperty
	private String contactNo;
	@JsonProperty
	private String email;
	@JsonProperty
	private String state;
	@JsonIgnore
	private String password;

}
