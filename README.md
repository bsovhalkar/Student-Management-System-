# Student Management System

A simple **Student Management System** built using **Spring Boot, MySQL, HTML, CSS, and JavaScript**.
It allows users to **add, view, and delete student records**.

## Features

* Add Student
* View Students
* Delete Student

## Technologies

* Spring Boot
* Spring Data JPA
* MySQL
* HTML, CSS, JavaScript

## Database Configuration

Update your database details in:

`src/main/resources/application.properties`

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

## Run the Application

1. Start MySQL and create database:

```sql
CREATE DATABASE student_management_system;
```

2. Run the Spring Boot application.

3. Open the **index.html** file in a browser.

Backend API runs on:

```
http://localhost:8080/students
```
