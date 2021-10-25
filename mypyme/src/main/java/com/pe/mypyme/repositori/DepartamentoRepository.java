package com.pe.mypyme.repositori;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.mypyme.model.Departamento;

@Repository
public interface DepartamentoRepository extends JpaRepository<Departamento, Integer> {

}
