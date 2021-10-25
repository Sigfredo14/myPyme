package com.pe.mypyme.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICRUD<T> {
    T registrar(T t);	
	T modificar(T t);	
	T buscar(Integer id);	
	boolean eliminar (Integer id);	
	List<T> listar();	
	
	

}




