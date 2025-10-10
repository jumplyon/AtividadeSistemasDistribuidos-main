package com.joaopedro.AtividadeSistemasDistribuidos.models;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity(name = "product")
@Table(name = "product", schema = "public")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private int codigo;
    private BigDecimal preco;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Category category;

    public Product() {
    }

    public Product(Long id, String nome, int codigo, BigDecimal preco, Category category) {
        this.id = id;
        this.nome = nome;
        this.codigo = codigo;
        this.preco = preco;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
