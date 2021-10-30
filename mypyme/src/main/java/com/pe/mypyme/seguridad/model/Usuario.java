package com.pe.mypyme.seguridad.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
@Entity
@Table(name = "t_usuario")
public class Usuario implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id_usuario;	
	
	@NotNull
	@Column(name = "v_usuario", unique = true)		
	@Size(min = 3, max = 15, message = "Usuario Tiene que ser entre 3 y 10 caracteres.")
	private String username;
	

	@NotNull
	@Column(name = "v_contrasenia")		
	private String password;
	
	
	@Column(name = "v_estado")		
	private Boolean estado;
	
	@NotNull
	@Column(name = "v_nombres_apellidos")	
	@Size(min = 2, max = 50, message = "Nombres Tiene que ser entre 2 y 50 caracteres.")
	private String nombresApellidos;
	
	
	@NotNull
	@Column(name = "v_correo")	
	private String correo;
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="usuario_id"),
			   inverseJoinColumns = @JoinColumn(name="rol_id"))
	private Set<Rol> roles = new HashSet<>();


	public Usuario(
			@NotNull @Size(min = 3, max = 15, message = "Usuario Tiene que ser entre 3 y 10 caracteres.") String username,
			@NotNull String password, Boolean estado,
			@NotNull @Size(min = 2, max = 50, message = "Nombres Tiene que ser entre 2 y 50 caracteres.") String nombresApellidos,
			@NotNull String correo) {
		super();
		this.username = username;
		this.password = password;
		this.estado = estado;
		this.nombresApellidos = nombresApellidos;
		this.correo = correo;
	}


	






	
	
	/*
	@ManyToOne
	@JoinColumn(name = "proveedor_id")	
	private Provedor proveedor;
	*/
	
	
	
}
