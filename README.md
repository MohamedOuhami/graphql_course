# Gestion des Étudiants et Filières - API GraphQL avec Spring

Bienvenue dans le projet de gestion des étudiants et des filières développé en utilisant Spring Boot et GraphQL. Ce projet vous permet de gérer les informations sur les étudiants et les filières de manière efficace en utilisant une API GraphQL.

## Configuration du Projet

### Prérequis

Assurez-vous d'avoir installé les éléments suivants sur votre machine avant de démarrer le projet :

- Java JDK 8 ou version ultérieure
- Maven
- Git

### Clonage du Projet

Clonez le projet depuis le dépôt GitHub en utilisant la commande suivante :

```bash
git clone https://github.com/MohamedOuhami/graphql_course
cd projet-gestion-etudiants
```

### Configuration de la Base de Données

Le projet utilise une base de données MySQL. Assurez-vous que vous avez une instance MySQL en cours d'exécution et configurez les paramètres de base de données dans le fichier `application.properties` situé dans le dossier `src/main/resources`. Modifiez les propriétés suivantes :

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/nom_de_votre_base_de_donnees
spring.datasource.username=votre_nom_d_utilisateur
spring.datasource.password=votre_mot_de_passe
```

### Compilation et Exécution

Compilez et exécutez le projet en utilisant Maven :

```bash
mvn clean install
mvn spring-boot:run
```

L'application sera accessible à l'adresse suivante : [http://localhost:8080](http://localhost:8080).

## Installation de Spring pour GraphQL

Assurez-vous d'inclure la dépendance Spring Boot GraphQL dans votre fichier `pom.xml` :

```xml
<dependency>
    <groupId>com.graphql-java-kickstart</groupId>
    <artifactId>graphql-spring-boot-starter</artifactId>
    <version>11.1.0</version> <!-- Vérifiez la dernière version sur Maven Central -->
</dependency>
```

## Exploration de l'API avec GraphiQL

GraphiQL est une interface utilisateur interactive qui facilite l'exploration et le test de l'API GraphQL. Vous pouvez y accéder à l'adresse suivante : [http://localhost:8080/graphiql](http://localhost:8080/graphiql).

## Schéma GraphQL

Le schéma GraphQL de l'API expose les fonctionnalités suivantes :

- `query`: Permet de récupérer des informations.
- `mutation`: Permet de modifier des données.

### Exemples de Requêtes GraphQL

#### Récupérer tous les étudiants

```graphql
query {
  students {
    id
    nom
    filiere {
      id
      code
    }
  }
}
```

#### Ajouter un nouvel étudiant

```graphql
mutation {
  addStudent(firstName: "Mohamed", lastName: "Ouhami", email: "mohamed.ouhami@gmail.com", filiereId: 1) {
    id
    name
    filiere {
      id
      code
    }
  }
}
```

### Documentation Additionnelle

Pour plus de détails sur les types de requêtes et de mutations disponibles, veuillez consulter la documentation générée automatiquement à l'adresse [http://localhost:8080/graphql/schema.json](http://localhost:8080/graphql/schema.json).

## Contribution

Les contributions sont les bienvenues ! Si vous souhaitez contribuer à ce projet, veuillez soumettre une pull request.

Merci d'avoir choisi notre API de gestion des étudiants et des filières avec Spring et GraphQL. Si vous avez des questions ou des problèmes, n'hésitez pas à ouvrir une issue.

Bonne programmation ! 🚀