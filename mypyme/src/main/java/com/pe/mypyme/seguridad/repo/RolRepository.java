package com.pe.mypyme.seguridad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.mypyme.seguridad.enums.RolNombre;
import com.pe.mypyme.seguridad.model.Rol;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer>{
	Optional<Rol> findByRolNombre(RolNombre rolNombre);
}
