package com.examen.ferreteria.controller;

import com.examen.ferreteria.dto.ArticuloCategoriaDto;
import com.examen.ferreteria.dto.ClienteFacturaDto;
import com.examen.ferreteria.dto.VentaCategoriaDto;
import com.examen.ferreteria.dto.VentaDetalleDto;
import com.examen.ferreteria.service.ReportesService;
import java.util.List;
import java.util.Map;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/** Endpoints de consulta usados por el frontend de reportes. */
@RestController
@CrossOrigin(origins = {"http://localhost:5173", "http://127.0.0.1:5173"})
public class ReportesController {

    private final ReportesService reportesService;

    public ReportesController(ReportesService reportesService) {
        this.reportesService = reportesService;
    }

    @GetMapping("/articulos/mostrarActivosFiltro")
    public List<Map<String, Object>> buscarArticulosActivos(
            @RequestParam(defaultValue = "") String nombre) {
        return reportesService.articulosActivos(nombre);
    }

    @GetMapping("/articulos/reporteArticuloCategoria")
    public List<ArticuloCategoriaDto> obtenerArticulosPorCategoria() {
        return reportesService.articulosCategoria();
    }

    // Se conserva la ruta original y se agrega un alias para Postman.
    @GetMapping({"/clientes/reporteClienteFactura", "/facturas/reporteFacturaCliente"})
    public List<ClienteFacturaDto> obtenerFacturasPorCliente() {
        return reportesService.clientesFacturas();
    }

    @GetMapping("/facturas/reporteDetalleVentas")
    public List<VentaDetalleDto> obtenerDetalleVentas() {
        return reportesService.ventasDetalle();
    }

    @GetMapping("/categorias/reporteVentasCategoria")
    public List<VentaCategoriaDto> obtenerVentasPorCategoria() {
        return reportesService.ventasCategoria();
    }
}
