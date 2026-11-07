package com.examen.ferreteria.dto;

import java.math.BigDecimal;

public record VentaCategoriaDto(
        String categoria,
        Long cantidad,
        BigDecimal total
) {}
