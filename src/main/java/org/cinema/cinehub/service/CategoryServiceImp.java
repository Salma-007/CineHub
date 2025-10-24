package org.cinema.cinehub.service;

import jakarta.transaction.Transactional;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.repository.CategoryRepo;
import org.cinema.cinehub.service.interfaces.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Category> getCategoryByid(Long id) {
        return categoryRepo.findById(id);
    }

    @Override
    public boolean deleteCategory(Long id) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if(categoryOptional.isPresent()){
            Category category = categoryOptional.get();
            if(category.getFilms() != null){
                return false;
            }
            try{
                categoryRepo.deleteById(id);
                return true;
            }catch (Exception e){
                return false;
            }
        }
        return false;
    }

    @Override
    public Category updateCategory(Long id, Category categoryDetails) {
        Optional<Category> existingCategoryOptional = categoryRepo.findById(id);

        if (existingCategoryOptional.isPresent()) {
            Category existingCategory = existingCategoryOptional.get();

            existingCategory.setName(categoryDetails.getName());
            existingCategory.setDescription(categoryDetails.getDescription());
            return categoryRepo.save(existingCategory);
        } else {
            return null;
        }
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }
}
