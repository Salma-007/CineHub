package org.cinema.cinehub.mapper;

import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.model.Director;
import org.cinema.cinehub.model.Film;
import org.springframework.stereotype.Component;

@Component
public class FilmMapper {
    public Film toEntity(FilmCreateDTO filmDTO, Category category, Director director) {
        Film film = new Film();
        film.setTitre(filmDTO.getTitre());
        film.setRating(filmDTO.getRating());
        film.setRelasedYear(filmDTO.getRelasedYear());
        film.setSynopsis(filmDTO.getSynopsis());
        film.setDuration(filmDTO.getDuration());
        film.setDirector(director);
        film.setCategory(category);
        return film;
    }

    public void updateFilmFromDTO(FilmCreateDTO dto, Film existingFilm, Category category, Director director) {
        existingFilm.setTitre(dto.getTitre());
        existingFilm.setRating(dto.getRating());
        existingFilm.setRelasedYear(dto.getRelasedYear());
        existingFilm.setSynopsis(dto.getSynopsis());
        existingFilm.setDuration(dto.getDuration());

        existingFilm.setCategory(category);
        existingFilm.setDirector(director);
    }

    public FilmCreateDTO toDto(Film film){
        if(film == null) return null;

        FilmCreateDTO dto = new FilmCreateDTO();

        dto.setId(film.getId());
        dto.setTitre(film.getTitre());
        dto.setRating(film.getRating());
        dto.setDuration(film.getDuration());
        dto.setRelasedYear(film.getRelasedYear());
        dto.setSynopsis(film.getSynopsis());

        if(film.getCategory() != null){
            dto.setCategoryName(film.getCategory().getName());
            dto.setCategoryId(film.getCategory().getId());
        }

        if (film.getDirector() != null){
            dto.setDirectorName(film.getDirector().getFirstName());
            dto.setDirectorId(film.getDirector().getId());
        }
        return dto;
    }
}
