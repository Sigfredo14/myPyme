package com.pe.mypyme.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.pe.mypyme.seguridad.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_provedor")
@Data @AllArgsConstructor @NoArgsConstructor
public class Provedor implements Serializable{
	private static final long serialVersionUID = 1L;	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private Integer id_provedor;
	
	
	@Column(name = "v_ruc",unique = true)
	private String ruc;
	
	
	@Column(name = "v_razonSocial",unique = true)
	@NotNull(message = "campo razonSocial no puede ser nulo")
	@Size(min = 10, max = 75, message = "Razon social tiene que ser entre 10 y 75 caracteres.")
	private String razonSocial;	
	
	
	@Column(name = "v_nombre_comercial")
	@NotNull(message = "campo nombre_comercial no puede ser nulo")
	@Size(min = 10, max = 75, message = "Nombre comercial tiene que ser entre 10 y 75 caracteres.")
	private String nombre_comercial;	
	
	
	@Column(name = "v_telefono")
	@NotNull(message = "campo telefono no puede ser nulo")
	@Size(min = 6, max = 8, message = "Telefono tiene que ser entre 6 y 8 caracteres.")
	private String telefono;	
	
	
	@Column(name = "v_celular")
	@NotNull(message = "campo celular no puede ser nulo")
	@Size(min = 9, max = 11, message = "Celular tiene que ser entre 9 y 11 caracteres.")
	private String celular;
	
	
	@Column(name = "v_correo",unique = true)
	@NotNull(message = "campo correo no puede ser nulo")
	@Size(min = 5, max = 50, message = "Correo tiene que ser entre 5 y 50 caracteres.")
	private String correo;
	
	
	@Column(name = "v_direccion")
	@NotNull(message = "campo direccion no puede ser nulo")
	@Size(min = 2, max = 50, message = "direccion tiene que ser entre 2 y 50 caracteres.")
	private String  direccion;
	
	
	@Column(name = "v_sector")	
	@NotNull(message = "campo sector no puede ser nulo")
	@Size(min = 1, max = 200, message = "sector tiene que ser entre 1 y 200 caracteres.")
	private String sector;	
	
	
	@Column(name = "b_estado")
	@NotNull
	private boolean estado;
	
	
	@Column(name = "d_fech_registro")	
	@Temporal(TemporalType.DATE)	
	private Date fecha_registro;
  
	
	
	
	
	@OneToOne
	private Usuario usuario;





	public Provedor(String ruc,
			@NotNull(message = "campo razonSocial no puede ser nulo") @Size(min = 10, max = 75, message = "Razon social tiene que ser entre 10 y 75 caracteres.") String razonSocial,
			@NotNull(message = "campo nombre_comercial no puede ser nulo") @Size(min = 10, max = 75, message = "Nombre comercial tiene que ser entre 10 y 75 caracteres.") String nombre_comercial,
			@NotNull(message = "campo telefono no puede ser nulo") @Size(min = 6, max = 8, message = "Telefono tiene que ser entre 6 y 8 caracteres.") String telefono,
			@NotNull(message = "campo celular no puede ser nulo") @Size(min = 9, max = 11, message = "Celular tiene que ser entre 9 y 11 caracteres.") String celular,
			@NotNull(message = "campo correo no puede ser nulo") @Size(min = 5, max = 50, message = "Correo tiene que ser entre 5 y 50 caracteres.") String correo,
			@NotNull(message = "campo direccion no puede ser nulo") @Size(min = 2, max = 50, message = "direccion tiene que ser entre 2 y 50 caracteres.") String direccion,
			@NotNull(message = "campo sector no puede ser nulo") @Size(min = 1, max = 200, message = "sector tiene que ser entre 1 y 200 caracteres.") String sector,
			@NotNull boolean estado) {
		super();
		this.ruc = ruc;
		this.razonSocial = razonSocial;
		this.nombre_comercial = nombre_comercial;
		this.telefono = telefono;
		this.celular = celular;
		this.correo = correo;
		this.direccion = direccion;
		this.sector = sector;
		this.estado = estado;
	}


	

	/* 
	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false,referencedColumnName = "id_distrito")	  
	private Distrito distrito;
	*/	
			
}
