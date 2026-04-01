# Student Management System

A **Student Management System** REST API built with **Spring Boot** and **MySQL**.  
It provides full CRUD operations to manage student records via a RESTful HTTP API.

## Features

* Add a new student
* Retrieve a single student by ID
* Retrieve all students
* Update an existing student
* Delete a student by ID
* Global exception handling with meaningful error responses

## Technologies

| Technology | Purpose |
|---|---|
| Java 21 | Programming language |
| Spring Boot 4.x | Application framework |
| Spring Data JPA | Database access layer |
| Spring Validation | Input validation |
| Hibernate | ORM / DDL management |
| MySQL | Relational database |
| Lombok | Boilerplate reduction (`@Getter`, `@Setter`) |
| Maven | Build and dependency management |

## Project Structure

```
src/
└── main/
    ├── java/com/app/student_management_system/
    │   ├── StudentManagementSystemApplication.java   # Spring Boot entry point
    │   ├── controller/
    │   │   └── StudentController.java                # REST endpoints
    │   ├── exception/
    │   │   ├── GlobalExceptionHandler.java           # @ControllerAdvice handler
    │   │   └── StudentNotFoundException.java         # Custom runtime exception
    │   ├── model/
    │   │   └── Student.java                          # JPA entity
    │   ├── repository/
    │   │   └── StudentRepository.java                # JpaRepository interface
    │   └── service/
    │       ├── StudentService.java                   # Service interface
    │       └── StudentServiceImp.java                # Service implementation
    └── resources/
        └── application.properties                    # DB and JPA configuration
```

## Student Model

The `Student` entity has the following fields:

| Field | Type | Description |
|---|---|---|
| `id` | `Long` | Auto-generated primary key |
| `firstName` | `String` | Student's first name |
| `lastName` | `String` | Student's last name |
| `department` | `String` | Department / faculty |
| `yearOfLearning` | `String` | Academic year |
| `age` | `Integer` | Student's age |
| `gender` | `String` | Student's gender |

## API Endpoints

Base URL: `http://localhost:8080`

| Method | Endpoint | Description | Request Body | Success Response |
|---|---|---|---|---|
| `GET` | `/` | Get all students | — | `200 OK` — list of students |
| `POST` | `/` | Add a new student | JSON `Student` | `201 Created` — created student |
| `GET` | `/{id}` | Get student by ID | — | `200 OK` — student object |
| `PUT` | `/{id}` | Update student by ID | JSON `Student` | `200 OK` — updated student |
| `DELETE` | `/{id}` | Delete student by ID | — | `200 OK` — confirmation message |

### Example Request Body

```json
{
  "firstName": "Jane",
  "lastName": "Doe",
  "department": "Computer Science",
  "yearOfLearning": "2nd Year",
  "age": 20,
  "gender": "Female"
}
```

### Error Response

When a student is not found, the API returns:

```
HTTP 404 Not Found
Student with ID <id> not found
```

## Database Configuration

Update `src/main/resources/application.properties` with your MySQL credentials:

```properties
spring.application.name=student-management-system
spring.datasource.url=jdbc:mysql://127.0.0.1:3306/student_management_system
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
spring.jpa.show-sql=true
```

Replace `YOUR_USERNAME` and `YOUR_PASSWORD` with your MySQL credentials.

## Setup & Run

### Prerequisites

* Java 21+
* Maven 3.x
* MySQL 8+

### Steps

1. **Create the database:**

```sql
CREATE DATABASE student_management_system;
```

2. **Update credentials** in `src/main/resources/application.properties`.

3. **Build the project:**

```bash
./mvnw clean package
```

4. **Run the application:**

```bash
./mvnw spring-boot:run
```

The API will be available at `http://localhost:8080`.

## Running Tests

```bash
./mvnw test
```
