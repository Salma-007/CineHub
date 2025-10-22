package org.cinema.cinehub.service.interfaces;

import org.cinema.cinehub.model.Film;

public interface FilmService {
    public Film createFilm(Film film);
    public Film getFilm(Long id);
}
