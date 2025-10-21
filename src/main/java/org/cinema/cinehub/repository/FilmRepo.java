package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepo extends JpaRepository<Film, Long> {

}
