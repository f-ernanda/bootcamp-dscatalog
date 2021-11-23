package dev.fernanda.dscatalog.services;

import dev.fernanda.dscatalog.dto.CategoryDTO;
import dev.fernanda.dscatalog.entities.Category;
import dev.fernanda.dscatalog.repositories.CategoryRepository;
import dev.fernanda.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> categories = categoryRepository.findAll();
        return categories.stream().map(CategoryDTO::new).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDTO findById(Long id) {
        Optional<Category> categoryOptional = categoryRepository.findById(id);
        Category category = categoryOptional.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new CategoryDTO(category);
    }
}
