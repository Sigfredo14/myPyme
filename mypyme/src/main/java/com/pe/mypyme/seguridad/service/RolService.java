package com.pe.mypyme.seguridad.service;

import java.util.List;
import java.util.Optional;

import com.pe.mypyme.seguridad.enums.RolNombre;
import com.pe.mypyme.seguridad.model.Rol;



public interface RolService {
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
	public void save(Rol rol);
	public List<Rol> listRol();
}
