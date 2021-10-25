package com.pe.mypyme.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "v_razonSocial")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 10, max = 75, message = "Razon social tiene que ser entre 10 y 75 caracteres.")
	private String razonSocial;
	
	
	@Column(name = "v_nombre_comercial")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 10, max = 75, message = "Nombre comercial tiene que ser entre 10 y 75 caracteres.")
	private String nombre_comercial;
	
	
	@Column(name = "v_telefono")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 6, max = 8, message = "Telefono tiene que ser entre 6 y 8 caracteres.")
	private String telefono;
	
	
	@Column(name = "v_celular")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 9, max = 11, message = "Celular tiene que ser entre 9 y 11 caracteres.")
	private String celular;
	
	@Column(name = "v_correo")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 10, max = 50, message = "Correo tiene que ser entre 10 y 50 caracteres.")
	private String correo;
	
	@Column(name = "v_administrativo")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 10, max = 45, message = "Administrativo tiene que ser entre 10 y 45 caracteres.")
	private String  administrativo;
	
	@Column(name = "v_cel_admin")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 9, max = 11, message = "Cel admin tiene que ser entre 9 y 11 caracteres.")
	private String cel_admin;
	
	@Column(name = "v_comercial")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 10, max = 50, message = "Comercial tiene que ser entre 10 y 50 caracteres.")
	private String comercial;
	
	@Column(name = "v_cel_comercial")
	@NotNull(message = "No puede estar vacio")
	@Size(min = 9, max = 11, message = "Cel comercial tiene que ser entre 9 y 11 caracteres.")
	private String cel_comercial;
	
	
	/*
    //@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "departamento_id", nullable = false,referencedColumnName = "id_departamento")	
	private Departamento departamento;  
	
	
    @ManyToOne
	@JoinColumn(name = "provincia_id", nullable = false,referencedColumnName = "id_provincia")	
	private Provincia provincia;
	*/	

	@ManyToOne
	@JoinColumn(name = "distrito_id", nullable = false,referencedColumnName = "id_distrito")	  
	private Distrito distrito;
}
