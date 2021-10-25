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
	
	@NotEmpty	
	@Column(name = "v_usuario", unique = true)		
	@Size(min = 5, max = 15, message = "Usuario Tiene que ser entre 5 y 15 caracteres.")
	private String usuario;	
	
	@Column(name = "v_nombres_apellidos")
	@NotNull(message = "campo no debe ser nullo")
	@Size(min = 2, max = 50, message = "Nombres Tiene que ser entre 2 y 50 caracteres.")
	private String nombres_apellidos;
	
	
	@Column(name = "v_estado")		
	private boolean estado;
	
	
	@Column(name = "v_contrasenia")
	@NotNull(message = "campo no debe ser nullo")
	@Size(min = 6, max = 15, message = "Contraseña Tiene que ser entre 6 y 15 caracteres.")
	private String password;	
	
	
	@ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="usuario_id"),
			   inverseJoinColumns = @JoinColumn(name="rol_id"))
	private Set<Rol> roles = new HashSet<>();


	public Usuario(
			@NotEmpty @Size(min = 5, max = 15, message = "Usuario Tiene que ser entre 5 y 15 caracteres.") String usuario,
			@NotNull(message = "campo no debe ser nullo") @Size(min = 2, max = 50, message = "Nombres Tiene que ser entre 2 y 50 caracteres.") String nombres_apellidos,
			boolean estado,
			@NotNull(message = "campo no debe ser nullo") @Size(min = 6, max = 15, message = "Contraseña Tiene que ser entre 6 y 15 caracteres.") String password) {
		super();
		this.usuario = usuario;
		this.nombres_apellidos = nombres_apellidos;
		this.estado = estado;
		this.password = password;
	}
	
	
	
	/*
	@ManyToOne
	@JoinColumn(name = "proveedor_id")	
	private Provedor proveedor;
	*/
	
	
	
}
