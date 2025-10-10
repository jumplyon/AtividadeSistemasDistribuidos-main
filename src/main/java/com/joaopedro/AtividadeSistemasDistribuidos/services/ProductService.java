package com.joaopedro.AtividadeSistemasDistribuidos.services;

import com.joaopedro.AtividadeSistemasDistribuidos.dtos.ProductRequestDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.dtos.ProductResponseDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.models.Category;
import com.joaopedro.AtividadeSistemasDistribuidos.models.Product;
import com.joaopedro.AtividadeSistemasDistribuidos.repositories.CategoryRepository;
import com.joaopedro.AtividadeSistemasDistribuidos.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    public ProductResponseDTO create(ProductRequestDTO productRequestDTO) {
        Category category = categoryRepository.findById(productRequestDTO.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + productRequestDTO.categoriaId()));

        Product newProduct = new Product();
        newProduct.setNome(productRequestDTO.nome());
        newProduct.setCodigo(productRequestDTO.codigo());
        newProduct.setPreco(productRequestDTO.preco());
        newProduct.setCategory(category);

        Product savedProduct = productRepository.save(newProduct);

        return mapToProductResponseDTO(savedProduct);
    }

    public List<ProductResponseDTO> findAll() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::mapToProductResponseDTO)
                .collect(Collectors.toList());
    }

    public ProductResponseDTO update(Long id, ProductRequestDTO productRequestDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        Category category = categoryRepository.findById(productRequestDTO.categoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada com o ID: " + productRequestDTO.categoriaId()));

        existingProduct.setNome(productRequestDTO.nome());
        existingProduct.setCodigo(productRequestDTO.codigo());
        existingProduct.setPreco(productRequestDTO.preco());
        existingProduct.setCategory(category);

        Product updatedProduct = productRepository.save(existingProduct);

        return mapToProductResponseDTO(updatedProduct);
    }

    public void delete(Long id) {
        if (!productRepository.existsById(id)) {
            throw new RuntimeException("Product not found with id: " + id);
        }
        productRepository.deleteById(id);
    }

    private ProductResponseDTO mapToProductResponseDTO(Product product) {
        return new ProductResponseDTO(
                product.getId(),
                product.getNome(),
                product.getCodigo(),
                product.getPreco(),
                product.getCategory() != null ? product.getCategory().getId() : null
        );
    }
}