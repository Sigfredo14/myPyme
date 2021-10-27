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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "t_provincia")
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Provincia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_provincia;
	
	@Column(name="v_descripcion")
	@NotNull(message = "campo descripcion no puede ser nulo")
	@Size(min = 2, max = 70, message = "Descripcion tiene que ser entre 2 y 70 caracteres.")
	private String descripcion;	
	
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "departamento_id", nullable = false)	
	 private Departamento departamento;	
	 
	
	 @OneToMany(mappedBy = "provincia",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	 Set<Distrito> distritos = new HashSet<Distrito>();

}
