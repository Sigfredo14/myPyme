package com.pe.mypyme.model;

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
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="t_clientes")
@Data @AllArgsConstructor @NoArgsConstructor
public class Cliente {
	@Id	
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_cliente;	
	
	@Column(name = "v_nombres")
	@NotNull(message = "campo nombres no puede ser nulo")
	@Size(min = 2, max = 70, message = "Nombres tiene que ser entre 2 y 70 caracteres.")
	private String nombres;	
	
	@Column(name = "v_apellidos")
	@NotNull(message = "campo apellidos no puede ser nulo")
	@Size(min = 2, max = 70, message = "Apellidos tiene que ser entre 2 y 70 caracteres.")
	private String apellidos;
	
	
	@Column(name = "v_celular")
	@NotNull(message = "campo celular no puede ser nulo")
	@Size(min = 9, max = 12, message = "Celular Tiene que ser entre 9 y 12 caracteres.")
	private String celular;
	
	@Column(name = "v_telefono")
	@NotNull(message = "campo telefono no puede ser nulo")
	@Size(min = 7, max = 10, message = "Telefono Tiene que ser entre 7 y 10 caracteres.")
	private String telefono;
	
	@Column(name = "v_direccion")
	@NotNull(message = "campo direccion no puede ser nulo")
	@Size(min = 2, max = 100, message = "Telefono Tiene que ser entre 2 y 100 caracteres.")	
	private String direccion;
	
	@Column(name = "c_estado")
	@NotNull(message = "campo estado no puede ser nulo")
	@Size(min = 1, max = 1, message = "Estado Tiene un caracter.")	
	private String estado;
	
	
	
	 @ManyToOne
	 @JoinColumn(name = "departamento_id", nullable = false)	
	 private Departamento departamento;		
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "provincia_id", nullable = false)
	 private Provincia provincia;
	
	 
	 @ManyToOne
	 @JoinColumn(name = "distrito_id", nullable = false)
	 private Distrito distrito;
	 

}
