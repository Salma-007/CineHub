package org.cinema.cinehub.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

    public FilmCreateDTO(String testFilmDto, int i, int i1, String synopsis, double v, long l, long l1) {
    }
}
