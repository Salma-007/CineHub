package org.cinema.cinehub.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
    private List<Film> films = new ArrayList<>();

}
