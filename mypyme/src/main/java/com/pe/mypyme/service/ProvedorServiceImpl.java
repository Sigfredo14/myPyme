package com.pe.mypyme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.pe.mypyme.model.Provedor;
import com.pe.mypyme.repositori.ProvedorRepository;
@Service
public class ProvedorServiceImpl implements ProvedorService{

	 @Autowired
	 private ProvedorRepository provedorRepository;
	
	@Override
	@Transactional(readOnly = false)
	public Provedor registrar(Provedor t) {		
		return provedorRepository.save(t);
	}

	@Override
	public Provedor modificar(Provedor t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Provedor buscar(Integer id) {		
		return provedorRepository.findById(id).get();
	}

	@Override
	public boolean eliminar(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	@Transactional(readOnly = true)
	public List<Provedor> listar() {
		// TODO Auto-generated method stub
		return provedorRepository.findAll();
	}

	@Override
	public Page<Provedor> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return provedorRepository.findAll(pageable);
	}

	@Override
	public Boolean existsByRazonSocial(String username) {
		// TODO Auto-generated method stub
		return  provedorRepository.existsByRazonSocial(username);
	}

	@Override
	public Boolean existsByCorreo(String correo) {
		// TODO Auto-generated method stub
		return provedorRepository.existsByCorreo(correo);
	}


	

}
