package org.cinema.cinehub.service;

import jakarta.transaction.Transactional;
import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.exception.CategoryNotFoundException;
import org.cinema.cinehub.exception.DirectorNotFoundException;
import org.cinema.cinehub.exception.FilmNotFoundException;
import org.cinema.cinehub.mapper.FilmMapper;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.model.Director;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.repository.CategoryRepo;
import org.cinema.cinehub.repository.DirectorRepo;
import org.cinema.cinehub.repository.FilmRepo;
import org.cinema.cinehub.service.interfaces.FilmService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class FilmServiceImp implements FilmService {

    private final FilmRepo filmRepo;
    private final CategoryRepo categoryRepo;
    private final DirectorRepo directorRepo;
    public final FilmMapper filmMapper;

    public FilmServiceImp(FilmRepo filmRepo, CategoryRepo categoryRepo,DirectorRepo directorRepo, FilmMapper filmMapper) {
        this.filmRepo = filmRepo;
        this.categoryRepo = categoryRepo;
        this.directorRepo = directorRepo;
        this.filmMapper = filmMapper;
    }

    @Override
    public Film createFilm(Film film) {
        return filmRepo.save(film);
    }

    @Override
    public Film getFilm(Long id) {
        return null;
    }

    @Override
    public Optional<Film> getFilmByTitre(String titre) {
        return filmRepo.findByTitre(titre);
    }

    @Override
    public Optional<Film> getFilmById(Long id) {
        return filmRepo.getFilmById(id);
    }

    @Override
    public boolean deleteFilm(Long id) {
        if (filmRepo.existsById(id)) {
            try {
                filmRepo.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public FilmCreateDTO updateFilm(Long id, FilmCreateDTO filmDTO) {
        Film existingFilm = filmRepo.findById(id)
                .orElseThrow(() -> new FilmNotFoundException("Film not found with id: " + id));

        Category category = categoryRepo.findById(filmDTO.getCategoryId())
                .orElseThrow(() -> new CategoryNotFoundException("Category not found!"));

        Director director = directorRepo.findById(filmDTO.getDirectorId())
                .orElseThrow(() -> new DirectorNotFoundException("Director not found!"));

        filmMapper.updateFilmFromDTO(filmDTO, existingFilm, category, director);

        Film updatedFilm = filmRepo.save(existingFilm);

        return filmMapper.toDto(updatedFilm);
    }

    @Override
    public List<FilmCreateDTO> getAllFilms() {
        return filmRepo.findAll().stream()
                .map(filmMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public Film createFilmFromDTO(FilmCreateDTO filmDTO) {
        Category category = categoryRepo.findById(filmDTO.getCategoryId()).orElseThrow(() -> new CategoryNotFoundException("Category not found!"));
        Director director = directorRepo.findById(filmDTO.getDirectorId()).orElseThrow(() -> new DirectorNotFoundException("Director not found!"));
        Film film = filmMapper.toEntity(filmDTO, category, director);
        return filmRepo.save(film);
    }

    @Override
    public List<FilmCreateDTO> getFilmsByYear(int realeasedYear) {
        return filmRepo.findFilmsByRelasedYear(realeasedYear).stream()
                .map(filmMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<FilmCreateDTO> getFilmsGreaterThanRating(Double rating) {
        return filmRepo.findFilmsByRatingGreaterThanEqual(rating).stream()
                .map(filmMapper::toDto)
                .collect(Collectors.toList());
    }
}
