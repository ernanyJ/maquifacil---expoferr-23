package com.cedrodoce.maqfacil.repository;

import com.cedrodoce.maqfacil.entities.Operador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long> {
}
