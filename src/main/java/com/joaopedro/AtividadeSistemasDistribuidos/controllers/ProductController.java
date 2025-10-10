package com.joaopedro.AtividadeSistemasDistribuidos.controllers;

import com.joaopedro.AtividadeSistemasDistribuidos.dtos.ProductRequestDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.dtos.ProductResponseDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO request){
        ProductResponseDTO newProduct = productService.create(request);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponseDTO>> findAllProducts(){
        List<ProductResponseDTO> products = productService.findAll();
        return ResponseEntity.ok(products);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponseDTO> updateProduct(@PathVariable Long id, @RequestBody ProductRequestDTO productRequestDTO){
        ProductResponseDTO updatedProduct = productService.update(id, productRequestDTO);

        return ResponseEntity.ok(updatedProduct);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id){
        productService.delete(id);

        return ResponseEntity.noContent().build();
    }

}
