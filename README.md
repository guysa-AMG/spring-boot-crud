# Todo Application

This is a full-stack web application designed to manage a list of customers. The application provides a simple and effective way to register new customers and view the existing ones. The backend is built with Spring Boot, and the frontend is developed using Angular. The entire application is containerized using Docker for easy deployment and scalability.

## Technologies Used

This project is built with a modern technology stack that ensures robustness, scalability, and maintainability. The key technologies used in this project are:

### Backend

- **Java 17**: The latest long-term support (LTS) version of Java, providing modern language features and performance improvements.
- **Spring Boot**: A powerful framework for building production-ready, stand-alone Spring-based applications.
- **Spring Data JPA**: Simplifies data access layers by providing a complete abstraction over JDBC and object-relational mapping.
- **PostgreSQL**: A powerful, open-source object-relational database system with a strong reputation for reliability, feature robustness, and performance.
- **Maven**: A powerful project management tool that is based on the concept of a project object model (POM).

### Frontend

- **Angular**: A platform for building mobile and desktop web applications.
- **TypeScript**: A strict syntactical superset of JavaScript that adds optional static typing.
- **HTML & CSS**: The standard markup language for creating web pages and cascading style sheets for styling them.

### Deployment & Monitoring

- **Docker**: A set of platform-as-a-service products that use OS-level virtualization to deliver software in packages called containers.
- **Docker Compose**: A tool for defining and running multi-container Docker applications.
- **Grafana**: A multi-platform open-source analytics and interactive visualization web application.

## Project Structure

The project is organized into a multi-module structure, with the backend and frontend code separated for clarity and maintainability.

```
/
├── docker-compose.yaml
├── Dockerfile
├── frontend/
│   ├── backend/
│   └── signup/
├── src/
│   ├── main/
│   │   ├── java/
│   │   └── resources/
│   └── test/
└── pom.xml
```

- **`docker-compose.yaml`**: Defines the services, networks, and volumes for the multi-container Docker application.
- **`Dockerfile`**: Contains the instructions for building the Docker image for the Spring Boot application.
- **`frontend/`**: Contains the frontend application code.
  - **`backend/`**: A simple Node.js backend that is not part of the main application.
  - **`signup/`**: The Angular frontend application for user registration.
- **`src/`**: Contains the source code for the Spring Boot backend application.
  - **`main/java/`**: The main application code.
  - **`main/resources/`**: The application configuration and static resources.
  - **`test/java/`**: The test code for the application.
- **`pom.xml`**: The Project Object Model (POM) file for the Maven project, defining the project's dependencies and build configuration.

## Getting Started

To get the application up and running, you will need to have Docker and Docker Compose installed on your machine.

### Prerequisites

- [Docker](https://docs.docker.com/get-docker/)
- [Docker Compose](https://docs.docker.com/compose/install/)

### Running the Application

1.  **Clone the repository**:
    ```sh
    git clone <repository-url>
    cd <repository-directory>
    ```

2.  **Build and run the application using Docker Compose**:
    ```sh
    docker-compose up --build
    ```

This command will build the Docker images for the Spring Boot application and the frontend, and then start all the services defined in the `docker-compose.yaml` file. The application will be available at the following URLs:

- **Spring Boot Backend**: `http://localhost:8080`
- **Angular Frontend**: `http://localhost:80`
- **Grafana**: `http://localhost:3030`

## API Endpoints

The backend provides the following RESTful API endpoints for managing customers:

- **`GET /users`**: Retrieves a list of all registered customers.
- **`POST /adduser`**: Adds a new customer to the database. The request body should be a JSON object with the following properties:
  - `name` (string)
  - `surname` (string)
  - `email` (string)
- **`DELETE /user/{id}`**: Removes a customer from the database based on their ID.

## Database

The application uses a PostgreSQL database to store customer information. The database is automatically configured and started as part of the Docker Compose setup. The database schema is managed by Spring Data JPA, which automatically creates the `customers` table based on the `Customers` entity.

The `customers` table has the following columns:

- `id` (integer, primary key)
- `name` (varchar)
- `surname` (varchar)
- `email` (varchar)
- `created_at` (timestamp)
- `last_seen` (timestamp)

## Frontend

The frontend is an Angular application that provides a user interface for registering new customers. The application consists of a simple form that collects the user's name, surname, and email address. When the form is submitted, the application sends a POST request to the backend's `/adduser` endpoint to register the new customer.

## Monitoring

The application is configured with Grafana for monitoring. Grafana is a powerful tool for visualizing metrics and logs, and it can be used to monitor the health and performance of the application. The Grafana instance is available at `http://localhost:3030`. You can configure Grafana to connect to the PostgreSQL database and visualize the data in the `customers` table.