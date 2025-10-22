package org.cinema.cinehub.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // IMPORTANT : C'est ici que Spring trouve les Services et la base de données.
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[] { RootConfig.class, JpaConfig.class };
        // Si JpaConfig contient le scan des Repositories, il doit être ici.
    }

    // C'est ici que Spring trouve les Contrôleurs.
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }
}
