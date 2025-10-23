package org.cinema.cinehub.service.interfaces;

import org.cinema.cinehub.model.Director;
import java.util.List;
import java.util.Optional;

public interface DirectorService {
    Director createDirector(Director director);
    Optional<Director> getDirectorByid(Long id);
    boolean deleteDirector(Long id);
    Director updateDirector(Long id, Director director);
    List<Director> getAllDirectors();
}
