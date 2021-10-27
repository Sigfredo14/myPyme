package com.pe.mypyme.seguridad.dto;

import java.util.HashSet;
import java.util.Set;
import javax.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data @AllArgsConstructor @NoArgsConstructor
public class NuevoUsuario {

	@NotBlank
	private String username;	

	@NotBlank
	private String password;
	
	
	private Boolean estado;		

	@NotBlank
	private String nombresApellidos;		
	

	private Set<String> roles = new HashSet<String>();
	
	
	
	
	
	
	
	
	
	
}
