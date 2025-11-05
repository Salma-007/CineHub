# 🎬 CinéHub – Gestion de Catalogue de Films (Spring MVC)

CinéHub est une application Java destinée à la gestion centralisée d’un catalogue cinématographique.  
Elle permet de gérer les **films**, **réalisateurs** et **catégories** avec une architecture professionnelle en couches (MVC) et les bonnes pratiques POO.

---

## 🚀 Objectifs du Projet

- Offrir un outil simple et fiable de gestion de catalogue de films
- Assurer l’automatisation des processus métier
- Appliquer les bonnes pratiques de conception (UML, POO, SOLID)
- Utiliser une architecture **MVC multi-couches**
- Gérer les données via **Spring & JPA/Hibernate**

---

## ✅ Fonctionnalités Principales

### 🎞 Gestion des Films
- Ajouter / Modifier / Supprimer un film
- Voir la liste complète des films
- Rechercher par titre, année ou catégorie
- Voir les détails d’un film (réalisateur + catégorie)

### 🎬 Gestion des Réalisateurs
- Ajouter / Modifier / Supprimer un réalisateur (si aucun film associé)
- Afficher la liste des réalisateurs
- Consulter la filmographie d’un réalisateur

### 🗂 Gestion des Catégories
- CRUD catégorie
- Afficher tous les films d’une catégorie
- Suppression possible seulement si aucun film associé

---

## 🏗️ Architecture & Technologies

| Technologie | Rôle |
|------------|------|
Java | Langage principal  
Spring Core | Injection de dépendances  
Spring MVC | Contrôleurs REST  
Spring Data JPA | Repositories  
Hibernate/JPA | Persistance  
MySQL/PostgreSQL | Base de données  
Java Time API | Dates (LocalDate)  

✅ Architecture **MVC – Repository / Service / Controller**

---

## ⚙️ Configuration Spring

- Configuration XML (`applicationContext.xml`)
- Annotation-based config (`@Component`, `@Service`, `@Repository`, `@Controller`)
- Java config (`@Configuration`, `@Bean`)
- Component Scanning activé
- Gestion des exceptions personnalisées
- Scopes : `singleton`, `prototype`

---


## 📎 Exécution du Projet

### Prérequis
- Java 8+ / 11 / 17
- Spring Framework
- Base MySQL/PostgreSQL
- IDE (IntelliJ / Eclipse / VSCode)

---

---

## 👤 Auteur
**Nom :** _Salma EL ALLALI_  
**Rôle :** Développeuse Java Full-Stack

---

🎥 *CinéHub — Votre gestionnaire de films, simple, centralisé et professionnel !*
