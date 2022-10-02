package com.springboot.author.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ApiResponse {

	public ApiResponse(String message, boolean sucess) {
		// TODO Auto-generated constructor stub
		this.message=message;
		this.success=sucess;
	}
	private String message;
	private Boolean success;
	
	
}
