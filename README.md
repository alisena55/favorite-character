# Favorite Character API

A REST API for the characters from my Assignment 2 website. The characters are fictional heroes and cartoon characters I grew up with, like Iron Man, Spider-Man, and Ben Tennyson.

Built with Spring Boot, PostgreSQL (Neon), and deployed on Render with Docker.

## Live API

https://favorite-character.onrender.com/api/characters

Note: this runs on Render's free plan, so it sleeps when not in use. The first request can take up to a minute.

## Character Attributes

| Attribute | Type | Rules |
|---|---|---|
| characterId | Long | Unique, auto-generated |
| name | String | Required |
| description | String | Required |
| universe | String | Optional (Marvel, Avatar, Cartoon Network, MGM) |
| role | String | Optional |
| species | String | Optional |
| powerLevel | Integer | Optional, 1 to 5 |
| firstAppearance | LocalDate | Optional, format yyyy-MM-dd |
| imageUrl | String | Optional |

## Endpoints

| Method | Path | Description | Success |
|---|---|---|---|
| GET | /api/characters | Get all characters | 200 |
| GET | /api/characters/{id} | Get one character by ID | 200 |
| POST | /api/characters | Add a character | 201 |
| PUT | /api/characters/{id} | Update a character | 200 |
| DELETE | /api/characters/{id} | Delete a character | 204 |
| GET | /api/characters?universe=Marvel | Filter by universe | 200 |
| GET | /api/characters?name=spi | Search by name (partial, case-insensitive) | 200 |

Errors: an ID that does not exist returns 404. A POST or PUT without a name or description returns 400.

### POST example

```json
{
  "name": "Iron Man",
  "description": "A weapons manufacturer who built his way out of a cave.",
  "universe": "Marvel",
  "role": "Founding Avenger",
  "species": "Human",
  "powerLevel": 4,
  "firstAppearance": "2008-05-02",
  "imageUrl": "images/iron-man.jpg"
}
```

### PUT example (`/api/characters/1`)

```json
{
  "name": "Iron Man",
  "description": "Engineer, arms dealer, Avenger, in that order.",
  "universe": "Marvel",
  "role": "Founding Avenger",
  "species": "Human",
  "powerLevel": 5,
  "firstAppearance": "2008-05-02",
  "imageUrl": "images/iron-man.jpg"
}
```

## Run Locally

Set the `SPRING_DATASOURCE_URL` environment variable to your Neon connection string, then run:

```
./mvnw spring-boot:run
```
