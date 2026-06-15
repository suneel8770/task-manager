Task Manager Backend Application

## Project Overview

This is a Task Tracking and Management Backend Application developed using Spring Boot and MySQL. The application helps users manage tasks, collaborate with team members, and organize projects efficiently.

## Features

### User Management

* User Registration
* User Login
* Update User Profile
* Secure Password Encryption using BCrypt

### Task Management

* Create Task
* View All Tasks
* View Task by ID
* Update Task
* Delete Task
* Assign Task to User
* Assign Task to Team
* Update Task Status
* Search Tasks by Title
* Filter Tasks by Status

### Team Management

* Create Team
* View All Teams
* Add Members to Team

### Collaboration

* Add Comments to Tasks
* View Task Comments
* Add Attachments to Tasks
* View Task Attachments

## Tech Stack

* Java 17
* Spring Boot
* Spring Data JPA
* Spring Security
* MySQL
* Maven
* Lombok

## Database

MySQL is used as the database for storing users, tasks, teams, comments, and attachments.

## API Endpoints

### User APIs

* POST /users
* POST /users/login
* GET /users
* PUT /users/{id}
* GET /users/{userId}/tasks

### Task APIs

* POST /tasks
* GET /tasks
* GET /tasks/{id}
* PUT /tasks/{id}
* DELETE /tasks/{id}
* PUT /tasks/{id}/status
* PUT /tasks/{taskId}/assign/{userId}
* PUT /tasks/{taskId}/team/{teamId}
* GET /tasks/status/{status}
* GET /tasks/search

### Team APIs

* POST /teams
* GET /teams
* POST /teams/{teamId}/users/{userId}

### Comment APIs

* POST /comments/task/{taskId}/user/{userId}
* GET /comments/task/{taskId}

### Attachment APIs

* POST /attachments/task/{taskId}
* GET /attachments/task/{taskId}

## How to Run

1. Clone the repository.
2. Create a MySQL database.
3. Configure database credentials in application.properties.
4. Run the Spring Boot application.
5. Test APIs using Postman.

## Author

Suneel Soni
