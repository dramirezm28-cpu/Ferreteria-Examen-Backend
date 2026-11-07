package com.examen.ferreteria.repository;
import com.examen.ferreteria.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {}
