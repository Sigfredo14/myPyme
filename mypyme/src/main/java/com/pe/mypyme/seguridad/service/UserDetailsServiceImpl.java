package com.pe.mypyme.seguridad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.pe.mypyme.seguridad.model.Usuario;
import com.pe.mypyme.seguridad.model.UsuarioPrincipal;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	
	@Autowired
	private UsuarioServiceImpl usuarioService;
	
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Usuario usuario = usuarioService.findByUsuario(username).get();
		
	return UsuarioPrincipal.build(usuario);
	}

}
