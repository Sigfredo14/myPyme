package com.pe.mypyme.seguridad.dto;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pe.mypyme.seguridad.model.Rol;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data @AllArgsConstructor
public class NuevoUsuario {

	@NotBlank
	private String usuario;	

	@NotBlank
	private String password;	

	@NotBlank
	private String nombres_apellidos;	
	
	@NotBlank
	private boolean estado;		
	
	@NotBlank
	private Set<Rol> roles = new HashSet<>();
}
