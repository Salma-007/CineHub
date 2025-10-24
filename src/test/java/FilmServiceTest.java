import org.cinema.cinehub.dto.FilmCreateDTO;
import org.cinema.cinehub.mapper.FilmMapper;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.model.Director;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.repository.CategoryRepo;
import org.cinema.cinehub.repository.DirectorRepo;
import org.cinema.cinehub.repository.FilmRepo;
import org.cinema.cinehub.service.FilmServiceImp;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class FilmServiceTest {
    @Mock
    private FilmRepo filmRepo;
    @Mock
    private CategoryRepo categoryRepo;
    @Mock
    private DirectorRepo directorRepo;
    @Mock
    private FilmMapper filmMapper;

    @InjectMocks
    private FilmServiceImp filmServiceImp;

    private Film film;
    private FilmCreateDTO filmCreateDTO;
    private Category category;
    private Director director;
    private final Long FILM_ID = 1L;
    private final Long NOT_FOUND_ID = 99L;

    @BeforeEach
    void setUp() {
        category = new Category();
        category.setId(1L);
        director = new Director();
        director.setId(2L);

        film = new Film();
        film.setId(FILM_ID);
        film.setTitre("Test Film");
        film.setCategory(category);
        film.setDirector(director);

        filmCreateDTO = new FilmCreateDTO("Test Film DTO", 2023, 120, "Synopsis", 8.0, 1L, 2L);
    }

    @Test
    void createFilmSuccess() {
        when(filmRepo.save(any(Film.class))).thenReturn(film);

        Film result = filmServiceImp.createFilm(film);

        assertNotNull(result, "The created film should not be null.");
        assertEquals(film.getTitre(), result.getTitre(), "The returned film should match the input.");

        verify(filmRepo, times(1)).save(film);
    }

    @Test
    void fetchFilmByIdSuccess(){

    }
}
