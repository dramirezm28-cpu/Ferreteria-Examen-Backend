package com.examen.ferreteria.dto;

import java.math.BigDecimal;
import java.util.Date;

public record ClienteFacturaDto(
        String nombre,
        String apellido,
        String nit,
        Date fechaFactura,
        BigDecimal total
) {}
