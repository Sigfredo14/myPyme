package com.pe.mypyme.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pe.mypyme.model.Provedor;
import com.pe.mypyme.service.ProvedorService;


@RestController
@RequestMapping("/provedor")
public class ProvedorRestController {
	
	@Autowired
	private ProvedorService provedorService;	
	
	
	@GetMapping
	public ResponseEntity<List<Provedor>> getAllProvedores(){
		return new ResponseEntity<>(provedorService.listar(), HttpStatus.OK);
	}	
	
	@GetMapping("/page/{page}")
	public ResponseEntity<Page<Provedor>> getAllProvedoresPage(@PathVariable Integer page){

		Pageable pageable = PageRequest.of(page, 8);

		return new ResponseEntity<>(provedorService.findAll(pageable), HttpStatus.OK);
	}
	
	
	
	
	@PostMapping("/crear")
	public ResponseEntity<?> saveProvedor(@Valid @RequestBody Provedor provedor, BindingResult results){
		Provedor provedorNuevo = null;
		Map<String, Object> response = new HashMap<>();
		
		if(results.hasErrors()) {
			List<String> errors = results.getFieldErrors()
					.stream()
					.map(er -> "El campo '" + er.getField() +"' " + er.getDefaultMessage())
					.collect(Collectors.toList());
			
			response.put("errors", errors);
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}
		
		
		
		try {
			provedorNuevo = provedorService.registrar(provedor);
			
						
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al insertar el provedor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}	
		
		response.put("mensaje", "El provedor ha sido creado con éxito!");
		response.put("provedor", provedorNuevo);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProvedor(@PathVariable Integer id){
		
		Map<String, Object> response = new HashMap<>();
		Provedor provedor = provedorService.buscar(id);
		
		if(provedor == null) {
			response.put("mensaje", "Error: No se pudo eliminar, el provedor con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}	
		
				
		
		try {
			provedorService.eliminar(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al eliminar el provedor en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		response.put("mensaje", "El provedor ha sido eliminado con éxito");
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	/*
	@GetMapping("/{id}")
	public ResponseEntity<?> getProvedor(@PathVariable Integer id){
		Optional<Provedor> provedor =null;
		Map<String, Object> response = new HashMap<>();
		
		
		if(provedor.isEmpty()) {
			
            response.put("mensaje", "El estudiante con el ID: ".concat(id.toString().concat(" no existe en la base de datos")));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.NOT_FOUND);
		}
		
		try {
			
			provedor = provedorService.buscar(id);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al consultar el estudiante en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		return new ResponseEntity<Estudiante>(estudiante.get(), HttpStatus.OK);
		
	}*/
	
	


}



