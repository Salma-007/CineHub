package org.cinema.cinehub;

import org.cinema.cinehub.config.AppConfig;
import org.cinema.cinehub.model.Category;
import org.cinema.cinehub.model.Film;
import org.cinema.cinehub.service.interfaces.CategoryService;
import org.cinema.cinehub.service.interfaces.FilmService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        FilmService filmService = context.getBean(FilmService.class);
        CategoryService categoryService = context.getBean(CategoryService.class);

        try {
            Category category = new Category();
            category.setName("Horror");
            category.setDescription("this cat is all about horror, for my scream lovers");
            categoryService.createCategory(category);

//            Film film = new Film();
//            film.setTitre("Scream");
//            film.setDuration(120);
//            film.setRelasedYear(2018);
//            film.setRating(6.5);
//            film.setSynopsis("horror");
//
//            Film savedFilm = filmService.createFilm(film);

            System.out.println("category created successfully");

        } catch (Exception e) {
            System.err.println("❌ Erreur: " + e.getMessage());
            e.printStackTrace();
        } finally {
            context.close();
        }
    }
}
