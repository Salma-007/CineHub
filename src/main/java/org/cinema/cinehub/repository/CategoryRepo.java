package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
