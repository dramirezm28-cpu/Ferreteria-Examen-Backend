package com.examen.ferreteria.service;

import com.examen.ferreteria.dto.ArticuloCategoriaDto;
import com.examen.ferreteria.dto.ClienteFacturaDto;
import com.examen.ferreteria.dto.VentaCategoriaDto;
import com.examen.ferreteria.dto.VentaDetalleDto;
import com.examen.ferreteria.entity.Articulo;
import com.examen.ferreteria.repository.ArticuloRepository;
import com.examen.ferreteria.repository.ReportesRepository;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class ReportesService {

    private final ArticuloRepository articuloRepository;
    private final ReportesRepository reportesRepository;

    public ReportesService(ArticuloRepository articuloRepository,
                           ReportesRepository reportesRepository) {
        this.articuloRepository = articuloRepository;
        this.reportesRepository = reportesRepository;
    }

    public List<Map<String, Object>> articulosActivos(String nombre) {
        return articuloRepository.buscarActivos(nombre).stream()
                .map(this::resumirArticulo)
                .toList();
    }

    private Map<String, Object> resumirArticulo(Articulo articulo) {
        Map<String, Object> resultado = new LinkedHashMap<>();
        resultado.put("idArticulo", articulo.getIdArticulo());
        resultado.put("nombre", articulo.getNombre());
        resultado.put("marca", articulo.getMarca());
        resultado.put("precio", articulo.getPrecio());
        resultado.put("stock", articulo.getStock());
        resultado.put("categoria", articulo.getIdCategoria() == null
                ? "" : articulo.getIdCategoria().getNombre());
        return resultado;
    }

    public List<ArticuloCategoriaDto> articulosCategoria() {
        return reportesRepository.articulosCategoria();
    }

    public List<ClienteFacturaDto> clientesFacturas() {
        return reportesRepository.clientesFacturas();
    }

    public List<VentaDetalleDto> ventasDetalle() {
        return reportesRepository.ventasDetalle();
    }

    public List<VentaCategoriaDto> ventasCategoria() {
        return reportesRepository.ventasCategoria();
    }
}
