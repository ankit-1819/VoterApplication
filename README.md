# Voter Application

A Spring Boot REST API for managing voter records with PostgreSQL.

## Overview

Voter Application is a backend application built with Java and Spring Boot. It provides REST APIs to create, retrieve, update, and delete voter records, with validation and centralized exception handling.

## Features

- Create a voter
- Get all voters
- Get a voter by ID
- Update voter details
- Delete a voter
- Input validation
- Age-based voter eligibility validation
- Custom exceptions
- Global exception handling
- DTO-based request and response handling
- PostgreSQL persistence using Spring Data JPA

## Technologies Used

- Java
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL
- Maven
- REST API
- Postman
- Git & GitHub

## Project Architecture

The application follows a layered architecture:

```
Controller
    ↓
Service
    ↓
Repository
    ↓
PostgreSQL
```

DTOs and a mapper are used to separate API request/response models from the database entity.

## API Endpoints

The application runs on port 8081 by default.

Base URL:

```
http://localhost:8081
```

| Method | Endpoint | Description |
|---|---|---|
| POST | /voter | Create a voter |
| GET | /voter | Get all voters |
| GET | /voter/{id} | Get voter by ID |
| PUT | /voter/{id} | Update voter |
| DELETE | /voter/{id} | Delete voter |

## Example Request

### Create Voter

```http
POST /voter
Content-Type: application/json
```

Example request body:

```json
{
  "name": "Rahul",
  "age": 25,
  "address": "Kolkata"
}
```

## Database Configuration

Create a PostgreSQL database named:

```
votingApp
```

Then update the database credentials in:

```
src/main/resources/application.properties
```

Example:

```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/votingApp
spring.datasource.username=postgres
spring.datasource.password=YOUR_PASSWORD
```

Do not commit real database passwords or other secrets to GitHub.

## Running the Application

### 1. Clone the repository

```bash
git clone https://github.com/ankit-1819/VoterApplication.git
```

### 2. Open the project

Import the project as a Maven project in Eclipse or another Java IDE.

### 3. Configure PostgreSQL

Create the votingApp database and update the database username/password in application.properties.

### 4. Run the application

Run VotingAppApplication.java.

The application will start on:

```
http://localhost:8081
```

## API Testing

The APIs were tested using Postman, including successful CRUD operations and validation/error scenarios.

## Future Improvements

- Add authentication and authorization
- Add automated unit and integration tests
- Add Swagger/OpenAPI documentation
- Add pagination and sorting
- Add Docker support
- Add CI/CD using GitHub Actions

## Author

Ankit Prasad

GitHub: https://github.com/ankit-1819