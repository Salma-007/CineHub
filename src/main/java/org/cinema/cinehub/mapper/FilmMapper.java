package org.cinema.cinehub.mapper;

import org.cinema.cinehub.dto.FilmDTO;
import org.cinema.cinehub.model.Film;

public class FilmMapper {
    public FilmDTO toDto(Film film){
        if(film == null) return null;
        FilmDTO dto = new FilmDTO();
        dto.setId(film.getId());
        dto.setTitre(film.getTitre());
        dto.setRating(film.getRating());
        dto.setDuration(film.getDuration());
        dto.setRelasedYear(film.getRelasedYear());
        dto.setSynopsis(film.getSynopsis());
        if(film.getCategory() != null){
            dto.setCategoryName(film.getCategory().getName());
        }

//        if (film.getDirector() != null)
//            dto.setDirectorName(film.getDirector().getName());

        return dto;
    }
}
