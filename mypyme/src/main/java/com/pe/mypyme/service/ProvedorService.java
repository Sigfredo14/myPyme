package com.pe.mypyme.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.pe.mypyme.model.Provedor;


public interface ProvedorService extends ICRUD<Provedor>{
	public Page<Provedor> findAll(Pageable pageable);
}
