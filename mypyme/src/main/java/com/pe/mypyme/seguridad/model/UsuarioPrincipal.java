package com.pe.mypyme.seguridad.model;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data  @AllArgsConstructor @NoArgsConstructor
public class UsuarioPrincipal implements UserDetails  {	
	
	private String usuario;		
	private String password;	
	private boolean estado;
	
	private Collection<? extends GrantedAuthority> authorities;
	
	
	public static UsuarioPrincipal build(Usuario usuario) {
		List<GrantedAuthority> authorities = usuario.getRoles()
				.stream()
				.map(rol -> new SimpleGrantedAuthority(rol.getRolNombre().name()))
				.collect(Collectors.toList());		
		
		return new UsuarioPrincipal(usuario.getUsuario(),usuario.getPassword(),usuario.isEstado(),authorities);
	}

	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usuario;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return estado;
	}
	

}
