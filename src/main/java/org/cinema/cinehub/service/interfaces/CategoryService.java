package org.cinema.cinehub.service.interfaces;

import org.cinema.cinehub.model.Category;

public interface CategoryService {
    public Category createCategory(Category cat);
    public Category getCategoryByid(Long id);
}
