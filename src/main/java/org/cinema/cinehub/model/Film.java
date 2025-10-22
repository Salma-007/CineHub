package org.cinema.cinehub.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "film")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String titre;

    @Column
    @Max(value = 2025, message = "L’année de sortie ne peut pas être dans le futur")
    private int relasedYear;

    @Column
    @Min(value = 1, message = "La durée doit être supérieure à 0")
    private int duration;

    @Column
    private String synopsis;

    @Column
    @DecimalMin(value = "1.0", message = "Le rating doit être au minimum 1")
    @DecimalMax(value = "10.0", message = "Le rating doit être au maximum 10")
    private Double rating;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="director_id")
    private Director director;

}
