package org.cinema.cinehub.service;

import jakarta.transaction.Transactional;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.repository.CategoryRepo;
import org.cinema.cinehub.service.interfaces.CategoryService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryServiceImp implements CategoryService {

    private final CategoryRepo categoryRepo;


    public CategoryServiceImp(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @Override
    public Category createCategory(Category cat) {
        return categoryRepo.save(cat);
    }
}
