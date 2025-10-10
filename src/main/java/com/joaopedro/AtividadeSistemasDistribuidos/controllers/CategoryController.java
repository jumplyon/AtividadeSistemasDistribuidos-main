package com.joaopedro.AtividadeSistemasDistribuidos.controllers;

import com.joaopedro.AtividadeSistemasDistribuidos.dtos.CategoryRequestDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.dtos.CategoryResponseDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/categorys")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponseDTO> createCategory(@RequestBody CategoryRequestDTO request){
        CategoryResponseDTO newCategory = categoryService.create(request);
        return new ResponseEntity<>(newCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponseDTO>> findAllCategorys(){
        List<CategoryResponseDTO> categorys = categoryService.findAll();
        return ResponseEntity.ok(categorys);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponseDTO> updateCategory(@PathVariable Long id, @RequestBody CategoryRequestDTO categoryRequestDTO){
        CategoryResponseDTO updatedCategory = categoryService.update(id, categoryRequestDTO);

        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);

        return ResponseEntity.noContent().build();
    }
}
