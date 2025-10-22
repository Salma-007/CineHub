package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DirectorRepo extends JpaRepository<Director, Long> {
}
