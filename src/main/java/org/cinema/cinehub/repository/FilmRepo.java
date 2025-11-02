package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {
    Optional<Film> findByTitre(String titre);
    Optional<Film> getFilmById(Long id);
    List<Film> findFilmsByRelasedYear(int releasedYear);
    List<Film> findFilmsByRatingGreaterThanEqual(Double rating);
    List<Film> findFilmsByCategoryName(String categoryName);
}
