package org.cinema.cinehub.controller;

import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.service.interfaces.FilmService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/films")
public class FilmController {
    private final FilmService filmService;

    public FilmController(FilmService filmService) {
        this.filmService = filmService;
    }

    @PostMapping(path = "/create")
    public ResponseEntity<Film> createFilm(@RequestBody FilmCreateDTO filmDTO) {
        Film createdFilm = filmService.createFilmFromDTO(filmDTO);
        return new ResponseEntity<>(createdFilm, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<FilmCreateDTO>> getAllFilms() {
        List<FilmCreateDTO> films = filmService.getAllFilms();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable("id") Long id){
        boolean deleted = filmService.deleteFilm(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search-by-title")
    public ResponseEntity<Film> getFilmByTitle(@RequestParam String titre){
        Optional<Film> film = filmService.getFilmByTitre(titre);
        if(film.isPresent()){
            Film fm = film.get();
            return new ResponseEntity<>(fm, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmCreateDTO> updateFilm(@PathVariable("id") Long id, @RequestBody FilmCreateDTO filmDTO) {
        try {
            FilmCreateDTO updatedFilm = filmService.updateFilm(id, filmDTO);
            return new ResponseEntity<>(updatedFilm, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/search-by-year")
    public ResponseEntity<List<FilmCreateDTO>> getFilmsByYear(@RequestParam("year") int year){
        List<FilmCreateDTO> films = filmService.getFilmsByYear(year);
        if(!films.isEmpty()){
            return new ResponseEntity<>(films, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
