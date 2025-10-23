package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {
    Optional<Film> findByTitre(String titre);
}
