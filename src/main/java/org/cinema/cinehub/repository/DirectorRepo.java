package org.cinema.cinehub.repository;

import org.cinema.cinehub.model.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DirectorRepo extends JpaRepository<Director, Long> {
    Optional<Director> getDirectorByLastName(String lastName);
}
