package org.cinema.cinehub.controller;

import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.model.Director;
import org.cinema.cinehub.service.interfaces.DirectorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/directors")
public class DirectorController {
    private final DirectorService directorService;

    public DirectorController(DirectorService directorService) {
        this.directorService = directorService;
    }

    @PostMapping
    public ResponseEntity<Director> createDirector(@RequestBody Director director) {
        Director createdDirector = directorService.createDirector(director);
        return new ResponseEntity<>(createdDirector, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Director>> getAllDirectors() {
        List<Director> directors = directorService.getAllDirectors();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirectorById(@PathVariable Long id) {
        Optional<Director> director = directorService.getDirectorByid(id);
        if(director.isPresent()){
            Director direc = director.get();
            return new ResponseEntity<>(direc, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDirector(@PathVariable Long id) {
        boolean deleted = directorService.deleteDirector(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@PathVariable Long id, @RequestBody Director directorDetails) {
        Director updatedDirector = directorService.updateDirector(id, directorDetails);
        if (updatedDirector != null) {
            return new ResponseEntity<>(updatedDirector, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
