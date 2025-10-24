package org.cinema.cinehub.service.interfaces;

import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.model.Film;

import java.util.List;
import java.util.Optional;

public interface FilmService {
    public Film createFilm(Film film);
    public Film getFilm(Long id);
    public Optional<Film> getFilmByTitre(String titre);
    public Optional<Film> getFilmById(Long id);
    boolean deleteFilm(Long id);
    FilmCreateDTO updateFilm(Long id, FilmCreateDTO filmDTO);
    public List<FilmCreateDTO> getAllFilms();
    public Film createFilmFromDTO(FilmCreateDTO filmDTO);
    List<FilmCreateDTO> getFilmsByYear(int realeasedYear);
    List<FilmCreateDTO> getFilmsGreaterThanRating(Double rating);
}
