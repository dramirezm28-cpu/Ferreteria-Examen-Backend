package com.examen.ferreteria.repository;

import com.examen.ferreteria.dto.ArticuloCategoriaDto;
import com.examen.ferreteria.dto.ClienteFacturaDto;
import com.examen.ferreteria.dto.VentaCategoriaDto;
import com.examen.ferreteria.dto.VentaDetalleDto;
import com.examen.ferreteria.entity.FacturaDetalle;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/** Consultas JPQL de los reportes. */
public interface ReportesRepository extends JpaRepository<FacturaDetalle, Integer> {

    @Query("""
            SELECT new com.examen.ferreteria.dto.ArticuloCategoriaDto(
                a.idArticulo, a.nombre, a.marca, c.nombre, a.precio, a.stock)
            FROM Articulo a JOIN a.idCategoria c
            WHERE a.estado = true AND c.estado = true
            ORDER BY c.nombre, a.nombre
            """)
    List<ArticuloCategoriaDto> articulosCategoria();

    @Query("""
            SELECT new com.examen.ferreteria.dto.ClienteFacturaDto(
                c.nombre, c.apellido, c.nit, f.fechaFactura, f.total)
            FROM Factura f JOIN f.idCliente c
            WHERE f.estado = true AND f.estadoFactura = true
            ORDER BY f.fechaFactura
            """)
    List<ClienteFacturaDto> clientesFacturas();

    @Query("""
            SELECT new com.examen.ferreteria.dto.VentaDetalleDto(
                f.idFactura, f.fechaFactura, CONCAT(c.nombre, ' ', c.apellido),
                a.nombre, cat.nombre, d.cantidad, d.precioUnitario, d.subtotal)
            FROM FacturaDetalle d
            JOIN d.idFactura f
            JOIN f.idCliente c
            JOIN d.idArticulo a
            JOIN a.idCategoria cat
            WHERE f.estado = true AND f.estadoFactura = true
            ORDER BY f.fechaFactura, f.idFactura
            """)
    List<VentaDetalleDto> ventasDetalle();

    @Query("""
            SELECT new com.examen.ferreteria.dto.VentaCategoriaDto(
                cat.nombre, SUM(CAST(d.cantidad AS long)), SUM(d.subtotal))
            FROM FacturaDetalle d
            JOIN d.idFactura f
            JOIN d.idArticulo a
            JOIN a.idCategoria cat
            WHERE f.estado = true AND f.estadoFactura = true
            GROUP BY cat.nombre
            ORDER BY SUM(d.subtotal) DESC
            """)
    List<VentaCategoriaDto> ventasCategoria();
}
