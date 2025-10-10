package com.joaopedro.AtividadeSistemasDistribuidos.dtos;

import java.math.BigDecimal;

public record ProductRequestDTO(String nome, int codigo, BigDecimal preco, Long categoriaId) {
}