# StudentRecordSystem

# Student Record Management System

A console-based Java application to manage student records using JDBC and MySQL.

## Features
- Add, view, search, update, and delete student records
- Data persists in MySQL database via JDBC
- Custom exception handling for invalid operations
- PreparedStatements for secure database queries

## Tech Stack
Java | JDBC | MySQL | OOP | Collections | Exception Handling | Git

## Database Setup
```sql
CREATE DATABASE studentdb;
USE studentdb;
CREATE TABLE students (
    id INT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    grade VARCHAR(5) NOT NULL
);
```

## How to Run
1. Clone the repo
2. Add `mysql-connector-j-9.7.0.jar` to the `lib/` folder
3. Update database password in `DatabaseHandler.java`
4. Compile and run `Main.java`

## Project Structure
- `Student.java` – Student model
- `DatabaseHandler.java` – JDBC connection and queries
- `RecordManager.java` – CRUD operations
- `StudentException.java` – Custom exception
- `Main.java` – Entry point with menu
