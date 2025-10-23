package org.cinema.cinehub.service.interfaces;

import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    Category createCategory(Category cat);
    Optional<Category> getCategoryByid(Long id);
    boolean deleteCategory(Long id);
    Category updateCategory(Long id, Category category);
    List<Category> getAllCategories();
}
