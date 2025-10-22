package org.cinema.cinehub;

import org.cinema.cinehub.config.AppConfig;
import org.cinema.cinehub.config.JpaConfig;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.service.FilmService;
import org.cinema.cinehub.service.FilmServiceImp;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        FilmService filmService = context.getBean(FilmService.class);
        try {
            Film film = new Film();
            film.setTitre("Inception");
            film.setDuration(148);
            film.setRelasedYear(2017);
            film.setSynopsis("Science-Fiction");

            Film savedFilm = filmService.createFilm(film);

            System.out.println("✅ Film créé avec ID: " + savedFilm.getId());

        } catch (Exception e) {
            System.err.println("❌ Erreur: " + e.getMessage());
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
