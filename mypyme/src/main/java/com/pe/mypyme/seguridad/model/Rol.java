package com.pe.mypyme.seguridad.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.pe.mypyme.seguridad.enums.RolNombre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_rol")
@Data @AllArgsConstructor @NoArgsConstructor
public class Rol {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id_rol;
	
	@NotNull
	@Enumerated(EnumType.STRING)
	@Column(name = "v_descripcion")
	private RolNombre rolNombre;

}
