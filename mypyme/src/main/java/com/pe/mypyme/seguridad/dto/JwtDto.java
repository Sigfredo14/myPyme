package com.pe.mypyme.seguridad.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data @AllArgsConstructor
public class JwtDto {	
	    private String token;
	    private String bearer = "Bearer";
	    private String username;
	    private Collection<? extends GrantedAuthority> authorities;

	    public JwtDto(String token, String nombreUsuario, Collection<? extends GrantedAuthority> authorities) {
	        this.token = token;
	        this.username = nombreUsuario;
	        this.authorities = authorities;
	    }
}
