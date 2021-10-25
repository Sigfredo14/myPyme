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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_distrito")
@Data @AllArgsConstructor @NoArgsConstructor
public class Distrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)	
	private int id_distrito;
	
	@Column(name="v_descripcion")
	@NotNull(message = "no puede estar vacío.")	
	@Size(min = 2, max = 70, message = "Descripcion tiene que ser entre 2 y 70 caracteres.")
	private String descripcion;
	
	
	
	
	 @JsonIgnore
	 @ManyToOne
	 @JoinColumn(name = "provincia_id")
	 private Provincia provincia;	
	

}
