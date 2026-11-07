package com.examen.ferreteria.repository;

import com.examen.ferreteria.entity.Articulo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ArticuloRepository extends JpaRepository<Articulo, Integer> {

    @Query("""
            SELECT a FROM Articulo a
            WHERE a.estado = true
              AND LOWER(a.nombre) LIKE LOWER(CONCAT('%', :nombre, '%'))
            ORDER BY a.nombre
            """)
    List<Articulo> buscarActivos(@Param("nombre") String nombre);
}
