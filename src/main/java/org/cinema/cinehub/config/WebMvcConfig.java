package org.cinema.cinehub.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "org.cinema.cinehub.controller") // Doit scanner vos contrôleurs
public class WebMvcConfig implements WebMvcConfigurer {

}
