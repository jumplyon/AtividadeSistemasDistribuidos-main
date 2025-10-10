package com.joaopedro.AtividadeSistemasDistribuidos.services;

import com.joaopedro.AtividadeSistemasDistribuidos.dtos.CategoryRequestDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.dtos.CategoryResponseDTO;
import com.joaopedro.AtividadeSistemasDistribuidos.models.Category;
import com.joaopedro.AtividadeSistemasDistribuidos.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public CategoryResponseDTO create(CategoryRequestDTO categoryRequestDTO) {
        Category newCategory = new Category();
        BeanUtils.copyProperties(categoryRequestDTO, newCategory);

        Category savedCategory = categoryRepository.save(newCategory);

        return new CategoryResponseDTO(
                savedCategory.getId(),
                savedCategory.getNome(),
                savedCategory.getDescricao()
        );
    }

    public List<CategoryResponseDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();

        return categories.stream()
                .map(category -> new CategoryResponseDTO(
                        category.getId(),
                        category.getNome(),
                        category.getDescricao()))
                .collect(Collectors.toList());
    }

    public void delete(Long id) {
        if (!categoryRepository.existsById(id)) {
            throw new RuntimeException("Category not found with id: " + id);
        }
        categoryRepository.deleteById(id);
    }

    public CategoryResponseDTO update(Long id, CategoryRequestDTO categoryRequestDTO) {
        Category existingCategory = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        BeanUtils.copyProperties(categoryRequestDTO, existingCategory);

        Category updatedCategory = categoryRepository.save(existingCategory);

        return new CategoryResponseDTO(
                updatedCategory.getId(),
                updatedCategory.getNome(),
                updatedCategory.getDescricao()
        );
    }
}