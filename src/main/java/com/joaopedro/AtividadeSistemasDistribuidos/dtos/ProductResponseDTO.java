package com.joaopedro.AtividadeSistemasDistribuidos.dtos;

import java.math.BigDecimal;

public record ProductResponseDTO(Long id, String nome, int codigo, BigDecimal preco, Long categoriaId) {
}