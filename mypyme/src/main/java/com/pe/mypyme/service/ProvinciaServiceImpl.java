package com.pe.mypyme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.pe.mypyme.model.Provincia;
import com.pe.mypyme.repositori.ProvinciaRepository;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{
	
	@Autowired
	private ProvinciaRepository proviRepo;

	@Override
	public Provincia registrar(Provincia t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Provincia modificar(Provincia t) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Override
	public Provincia buscar(Integer id) {
		// TODO Auto-generated method stub
		return proviRepo.findById(id).get();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Transactional(readOnly = true, propagation = Propagation.REQUIRED)
	@Override
	public List<Provincia> listar() {
		// TODO Auto-generated method stub
		return proviRepo.findAll();
	}

}
