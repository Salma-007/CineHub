package org.cinema.cinehub.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity(name = "director")
public class Director {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String nationality;

    @Column(nullable = false)
    private String biography;

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToMany(mappedBy = "director", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<Film> films = new ArrayList<>();

}
