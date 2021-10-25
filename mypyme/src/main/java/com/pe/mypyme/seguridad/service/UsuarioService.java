package com.pe.mypyme.seguridad.service;

import java.util.Optional;

import com.pe.mypyme.seguridad.model.Usuario;

public interface UsuarioService {
	Optional<Usuario> findByUsuario(String username);
	Boolean existsByUsuario(String username);
	Usuario save(Usuario usuario);
	Usuario findById(Integer id);
	void delete(Integer id);
}
