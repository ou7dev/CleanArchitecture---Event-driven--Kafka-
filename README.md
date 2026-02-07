# Clean Architecture + Event Driven (Kafka) with Spring Boot

This project demonstrates a Spring Boot application implementing **Clean Architecture** principles and **Event-Driven Architecture** using Apache Kafka. It focuses on loose coupling and separation of concerns.

## 🚀 Technologies

- **Java 17**
- **Spring Boot 4.0.2**
- **Spring Data JPA**
- **Apache Kafka** (with Zookeeper)
- **H2 Database** (In-memory database for testing/dev)
- **Lombok**
- **Docker & Docker Compose**

## 🏗 Architecture

The project follows the Clean Architecture layers:

- **Domain**: Core business logic and entities (e.g., `Student`). Independent of frameworks.
- **Application**: Use cases acting as the glue between the domain and outer layers (e.g., `FindUserUseCase`, `CreateUserUseCase`).
- **Infrastructure**: Implementation details like databases (`StudentRepositoryAdapter`), configuration, and external services.
- **Presentation**: Entry points like REST Controllers (`StudentController`).

## 🛠 Prerequisites

- Java 17 SDK
- Maven
- Docker & Docker Compose

## 🏁 Getting Started

### 1. Start Infrastructure (Kafka & Zookeeper)
Use Docker Compose to start the required infrastructure services.
```bash
docker-compose up -d
```

### 2. Build the Application
```bash
mvn clean install
```

### 3. Run the Application
```bash
mvn spring-boot:run
```
The application will start on port `8080` (default).

## 🔌 API Endpoints

### Student Management
Base URL: `/api/v1`

| Method | Endpoint | Description | Payload |
| :--- | :--- | :--- | :--- |
| `POST` | `/create-student` | Create a new student | `{"name": "...", "email": "...", "password": "...", "role": "..."}` |
| `GET` | `/student/{uuid}` | Get student by UUID | N/A |
| `GET` | `/students` | Get all students | N/A |

## 🗄 Database (H2)
The application uses an H2 in-memory database.
- **Console URL**: `http://localhost:8080/h2-console` (Enable in `application.properties` if needed)
- **JDBC URL**: Configured in `application.properties`

