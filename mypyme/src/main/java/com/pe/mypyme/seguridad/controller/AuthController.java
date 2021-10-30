package com.pe.mypyme.seguridad.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.mypyme.seguridad.dto.JwtDto;
import com.pe.mypyme.seguridad.dto.LoginUsuario;
import com.pe.mypyme.seguridad.dto.NuevoUsuario;
import com.pe.mypyme.seguridad.enums.RolNombre;
import com.pe.mypyme.seguridad.jwt.JwtProvider;
import com.pe.mypyme.seguridad.model.Rol;
import com.pe.mypyme.seguridad.model.Usuario;
import com.pe.mypyme.seguridad.service.RolService;
import com.pe.mypyme.seguridad.service.UsuarioService;


@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = {"http://localhost:4200"})
public class AuthController {
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private AuthenticationManager authManager;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private PasswordEncoder passwordEnconder;
	
	@Autowired
	private RolService rolService;
	
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@Valid @RequestBody LoginUsuario loginUsuario, BindingResult result){
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}		
		
		Authentication auth = authManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(loginUsuario.getUsername(), loginUsuario.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(auth);
		
		String jwt = jwtProvider.generatToken(auth);
		
		JwtDto jwtDto = new JwtDto(jwt);
		
		response.put("mensaje", "Login exitoso");
		response.put("jwtDto", jwtDto);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NuevoUsuario nuevoUsuario, BindingResult result){
		
		Map<String, Object> response = new HashMap<>();
		
		if(result.hasErrors()) {
			List<String> errors = result.getFieldErrors()
					.stream()
					.map(err -> "El campo estoy aki '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		
		if(usuarioService.existsByUsername(nuevoUsuario.getUsername())) {
			response.put("mensaje", "El usuario ya existe");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);

		}		

		Usuario usuario = new Usuario(nuevoUsuario.getUsername(),passwordEnconder.encode(nuevoUsuario.getPassword()),true,nuevoUsuario.getNombresApellidos(), nuevoUsuario.getCorreo());

		Set<Rol> roles = new HashSet<>();
		roles.add(rolService.findByRolNombre(RolNombre.ROLE_USER).get());	
        
        
		if(nuevoUsuario.getRoles().contains("ROLE_ADMIN")){
			roles.add(rolService.findByRolNombre(RolNombre.ROLE_ADMIN).get());
		}
		
		
		usuario.setRoles(roles);
		
		Usuario usuarioCreado = usuarioService.save(usuario);
		
		response.put("mensaje", "Usuario guardado");
		response.put("usuario", usuarioCreado);
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/listarRoles")
	public ResponseEntity<?>listaRoles(){		
		List<Rol> listaRoles = rolService.listRol();
		
		return new ResponseEntity<>(listaRoles,HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
}
