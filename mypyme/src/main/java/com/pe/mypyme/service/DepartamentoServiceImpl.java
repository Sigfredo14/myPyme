package com.pe.mypyme.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pe.mypyme.model.Departamento;
import com.pe.mypyme.repositori.DepartamentoRepository;
@Service
public class DepartamentoServiceImpl implements DepartamentoService {
	
	@Autowired
	private DepartamentoRepository depaService;
	

	@Override
	public Departamento registrar(Departamento t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Departamento modificar(Departamento t) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Override
	public Departamento buscar(Integer id) {		
		return depaService.findById(id).get();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
    
	//propagation = Propagation.REQUIRED crea si no hay una transaccion  
	//no es necesario ponerlo por que ya biene por defecto en ese tipo de propagacion
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Override	
	public List<Departamento> listar() {		
		return depaService.findAll();
	}

}
