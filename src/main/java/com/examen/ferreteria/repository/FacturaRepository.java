package com.examen.ferreteria.repository;
import com.examen.ferreteria.entity.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
public interface FacturaRepository extends JpaRepository<Factura, Integer> {}
