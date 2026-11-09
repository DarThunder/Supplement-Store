
package com.proyecto.sistema.service;

import com.proyecto.sistema.model.Category;
import com.proyecto.sistema.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> list() {
        return repository.list();
    }

    public Optional<Category> findByID(int id) {
        return repository.findByID(id);
    }

    public int save(Category category) {
        return repository.save(category);
    }

    public boolean update(Category category) {
        return repository.update(category) > 0;
    }

    public boolean remove(int id) {
        return repository.remove(id) > 0;
    }
}
