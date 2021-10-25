package com.pe.mypyme.seguridad.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pe.mypyme.seguridad.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	Optional<Usuario> findByUsuario(String usuario);
	Boolean existsByUsuario(String usuario);
}
