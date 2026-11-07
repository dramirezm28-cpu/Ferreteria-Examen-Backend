package com.examen.ferreteria.dto;

import java.math.BigDecimal;

public record ArticuloCategoriaDto(
        Integer idArticulo,
        String nombre,
        String marca,
        String categoria,
        BigDecimal precio,
        Integer stock
) {}
