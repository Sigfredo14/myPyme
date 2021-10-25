package com.pe.mypyme.seguridad.dto;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class LoginUsuario {
	
	@NotBlank
	private String usuario;	

	@NotBlank
	private String password;
}
