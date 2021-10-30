package com.pe.mypyme.seguridad.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.mypyme.seguridad.enums.RolNombre;
import com.pe.mypyme.seguridad.model.Rol;
import com.pe.mypyme.seguridad.repo.RolRepository;
@Service
public class RolServiceImpl implements RolService {
	
	@Autowired
	private RolRepository rolRepository;

	@Override
	public Optional<Rol> findByRolNombre(RolNombre rolNombre) {
		
		return rolRepository.findByRolNombre(rolNombre);
	}
	
	@Override
	public void save(Rol rol) {
		rolRepository.save(rol);
	}

	@Override
	public List<Rol> listRol() {		
		return rolRepository.findAll();
	}

}
