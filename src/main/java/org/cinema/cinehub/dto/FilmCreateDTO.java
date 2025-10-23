package org.cinema.cinehub.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilmCreateDTO {
    private Long id;
    private String titre;
    private int relasedYear;
    private int duration;
    private String synopsis;
    private Double rating;

    private Long categoryId;
    private Long directorId;

    private String categoryName;
    private String directorName;
}
