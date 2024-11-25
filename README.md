# YouQuiz - Application de Gestion des Tests et des Quizzes

## Contexte du Projet
L'application YouQuiz a été conçue pour automatiser l'administration des examens et des quiz dans le cadre de l'éducation et de l'enseignement. Ce premier module fait partie d'une plateforme complète d'eLearning, visant à offrir aux formateurs et étudiants une interface pour créer, administrer, et passer des tests.

## Exigences Fonctionnelles

- **Test (Examen)** : Un test est rédigé par un formateur et peut concerner un ou plusieurs sujets.
- **Sujets** : Un sujet peut être subdivisé en sous-sujets et avoir des sujets parents.
- **Questions** : Une question appartient à un seul sujet, a plusieurs réponses possibles (correctes ou fausses), et peut être temporisée selon le test.
- **Étudiants et Formateurs** : Les étudiants peuvent passer plusieurs fois un test après demande au formateur. Les formateurs peuvent programmer les tests à des dates et heures spécifiques.
- **Suivi des Résultats** : Le système doit enregistrer les réponses, les scores, le nombre de tentatives et les résultats obtenus par chaque étudiant.

## Exigences Techniques

- **Technologies utilisées** :
    - Spring Boot
    - Spring Data
    - PostgreSQL (base de données relationnelle)
    - JUnit, Mockito pour les tests
    - Spring Web pour l'API REST
    - Lombok pour la gestion des getters, setters et constructeurs

## Fonctionnalités Clés

- **Gestion des Tests** : Créer et programmer des tests, définir des critères de réussite, nombre de tentatives, etc.
- **Gestion des Sujets** : Créer des sujets et des sous-sujets pour organiser les questions.
- **Gestion des Questions** : Créer des questions avec plusieurs réponses et gérer leur temporisation dans le cadre des tests.
- **Suivi des Étudiants** : Permet aux étudiants de passer des tests et de revoir leurs résultats.
- **Enregistrement des Résultats** : Stocker les résultats des étudiants, leur score par question et la tentative de test.

## Technologies et Concepts

- **Spring Core** : Pour la gestion des dépendances et l'injection de dépendances.
- **Spring Boot** : Pour simplifier la configuration et le déploiement de l'application.
- **Spring Data** : Pour gérer l'accès aux données avec Spring Data JPA.
- **Spring Web** : Pour créer l'API REST.
- **Lombok** : Pour éviter l'écriture manuelle de getters, setters et autres méthodes boilerplate.
- **JUnit et Mockito** : Pour la gestion des tests unitaires et des tests de mock.

## Architecture du Projet

- **Modèle de données** : Le système repose sur plusieurs entités telles que `Test`, `Question`, `Réponse`, `Sujet`, `Niveau`, `Étudiant`, `Formateur`, etc.
- **API** : L'application expose des endpoints REST pour interagir avec les données de test, de question, et de résultats.


### Class Diagram Description:
- **Test**: This class holds the main information about an exam, including the test name, score thresholds, and schedule.
- **Sujet**: Represents the topics that form the content of the tests, which can have subtopics and parent-child relationships.
- **Question**: A question is attached to a specific topic and has multiple possible answers, with correct/incorrect labels and scoring.
- **Réponse**: The answer options for questions, where each answer can be marked as correct for one question but not for another.
- **Formateur and Étudiant**: These entities represent the instructor and the student, with personal details and roles in the system.

