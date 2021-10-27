package com.pe.mypyme.seguridad.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class LoginUsuario {
	
	@NotBlank
	private String username;	

	@NotBlank
	private String password;
}
