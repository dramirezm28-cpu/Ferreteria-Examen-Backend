package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import java.util.Date;

public record VentaDetalleDto(
        Integer idFactura,
        Date fechaFactura,
        String cliente,
        String articulo,
        String categoria,
        Integer cantidad,
        BigDecimal precioUnitario,
        BigDecimal subtotal
) {}
