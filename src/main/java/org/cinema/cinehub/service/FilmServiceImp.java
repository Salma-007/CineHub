package org.cinema.cinehub.service;

import jakarta.transaction.Transactional;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.repository.FilmRepo;
import org.cinema.cinehub.service.interfaces.FilmService;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class FilmServiceImp implements FilmService {

    private final FilmRepo filmRepo;

    public FilmServiceImp(FilmRepo filmRepo) {
        this.filmRepo = filmRepo;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public Film getFilm(Long id) {
        return null;
    }
}
