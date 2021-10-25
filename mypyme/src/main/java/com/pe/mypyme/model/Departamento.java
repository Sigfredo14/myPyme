package com.pe.mypyme.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_departamento")
@Data @AllArgsConstructor @NoArgsConstructor
public class Departamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_departamento;
	
	@Column(name = "v_departamento")
	@NotNull(message = "no puede estar vacío.")	
	@Size(min = 2, max = 70, message = "descripcion tiene que ser entre 2 y 70 caracteres.")
	private String descripcion;
	
	
	
	
	@OneToMany(mappedBy = "departamento",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	Set<Cliente> clientes = new HashSet<Cliente>();	
	
	
	@OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	Set<Provincia> provincias = new HashSet<Provincia>();

}
