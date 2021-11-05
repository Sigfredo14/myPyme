package com.pe.mypyme.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.mypyme.model.Provedor;
@Repository
public interface ProvedorRepository extends JpaRepository<Provedor, Integer>{
	Boolean existsByRazonSocial(String username);
	Boolean existsByCorreo(String correo);
}
