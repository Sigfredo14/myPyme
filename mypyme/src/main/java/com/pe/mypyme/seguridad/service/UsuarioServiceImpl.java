package com.pe.mypyme.seguridad.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pe.mypyme.seguridad.model.Usuario;
import com.pe.mypyme.seguridad.repo.UsuarioRepository;
@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepo;

	@Override
	public Optional<Usuario> findByUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioRepo.findByUsuario(username);
	}

	@Override
	public Boolean existsByUsuario(String username) {
		// TODO Auto-generated method stub
		return usuarioRepo.existsByUsuario(username);
	}

	@Override
	public Usuario save(Usuario usuario) {
		// TODO Auto-generated method stub
		return usuarioRepo.save(usuario);
	}

	@Override
	public Usuario findById(Integer id) {
		// TODO Auto-generated method stub
		return usuarioRepo.findById(id).orElse(null);
	}

	@Override
	public void delete(Integer id) {
		usuarioRepo.deleteById(id);
		
	}

	

	

}
