package org.cinema.cinehub.service;

import jakarta.transaction.Transactional;
import org.cinema.cinehub.model.Director;
import org.cinema.cinehub.repository.DirectorRepo;
import org.cinema.cinehub.service.interfaces.DirectorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class DirectorServiceImp implements DirectorService {

    private final DirectorRepo directorRepo;

    public DirectorServiceImp(DirectorRepo directorRepo) {
        this.directorRepo = directorRepo;
    }

    @Override
    public Director createDirector(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public Optional<Director> getDirectorByid(Long id) {
        return directorRepo.findById(id);
    }

    @Override
    public boolean deleteDirector(Long id) {
        Optional<Director> directorOptional = directorRepo.findById(id);

        if (directorOptional.isPresent()) {
            Director director = directorOptional.get();
            if (director.getFilms() != null) {
                return false;
            }
            try {
                directorRepo.deleteById(id);
                return true;
            } catch (Exception e) {
                return false;
            }
        }
        return false;
    }

    @Override
    public Director updateDirector(Long id, Director directorDetails) {
        Optional<Director> existingDirectorOptional = directorRepo.findById(id);

        if (existingDirectorOptional.isPresent()) {
            Director existingDirector = existingDirectorOptional.get();

            existingDirector.setFirstName(directorDetails.getFirstName());
            existingDirector.setLastName(directorDetails.getLastName());
            existingDirector.setNationality(directorDetails.getNationality());
            existingDirector.setBiography(directorDetails.getBiography());
            existingDirector.setBirthDate(directorDetails.getBirthDate());

            return directorRepo.save(existingDirector);
        } else {
            return null;
        }
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepo.findAll();
    }

    @Override
    public Optional<Director> getDirectorByName(String lastName) {
        return directorRepo.getDirectorByLastName(lastName);
    }
}
