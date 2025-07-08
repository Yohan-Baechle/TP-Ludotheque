# Ludothèque

Application de gestion de ludothèque développée avec Spring Boot et JPA. Il s'agit d'un projet pédagogique réalisé durant ma formation CDA à l'ENI.

## Description

Ce projet permet de gérer une ludothèque avec les fonctionnalités suivantes :
- Gestion des clients et leurs adresses
- Gestion des jeux et leurs genres
- Gestion des exemplaires de jeux
- Système de base de données relationnelle

## Technologies utilisées

- **Java** avec Spring Boot
- **Spring Data JPA** pour la couche d'accès aux données
- **Lombok** pour la réduction du code boilerplate
- **Gradle** pour la gestion des dépendances
- **Base de données** : LUDO_DB

## Configuration

### Base de données
- **Nom de la base** : `LUDO_DB`
- **Utilisateur** : `LUDO_USER`
- **Mot de passe** : `LUDO_PWD`

La configuration se trouve dans le fichier `application.yml`.

## Structure du projet

### Entités principales
- **Client** : Gestion des clients de la ludothèque
- **Adresse** : Adresses des clients (relation One-to-One)
- **Jeu** : Catalogue des jeux disponibles
- **Genre** : Classification des jeux par genre
- **Exemplaire** : Instances physiques des jeux

### Relations
- Client ↔ Adresse (One-to-One)
- Jeu ↔ Genre (Many-to-Many)
- Jeu → Exemplaire (One-to-Many)

## Installation

1. Cloner le repository
```bash
git clone git@github.com:Yohan-Baechle/TP-Ludotheque.git
cd TP-Ludotheque
```

2. Configurer la base de données dans `application.yml`

3. Lancer l'application

## Développement

### Workflow Git
- Chaque story est développée dans une branche spécifique
- Format des branches : `S1001`, `S1002`, etc.
- Merge vers `main` après validation

### Tests
Le projet inclut des tests unitaires pour :
- Ajout de clients avec adresse
- Ajout de genres
- Ajout de jeux avec genres associés
- Ajout d'exemplaires

## Itération 01 - Roadmap

- [x] S1001 : Création du projet et configuration Gradle
- [x] S1002 : Création du dépôt Git et synchronisation GitHub
- [x] S1003 : Couche DAL - Entité Client
- [x] S1004 : Couche DAL - Relation Client/Adresse
- [x] S1005 : Couche DAL - Entité Jeu
- [x] S1006 : Couche DAL - Entité Genre
- [x] S1007 : Couche DAL - Relation Jeu/Genre
- [x] S1008 : Couche DAL - Entité Exemplaire
- [x] S1009 : Configuration utilisateur base de données

## Auteur

Développé par Yohan Baechlé
