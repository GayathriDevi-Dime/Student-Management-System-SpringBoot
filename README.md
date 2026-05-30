# Student Management System - Spring Boot

## About the Project

This is a Student Management System backend project built using Spring Boot.
The project performs CRUD operations (Create, Read, Update, Delete) for student data.

## Tech Stack

* Java
* Spring Boot
* Spring Data JPA
* MySQL
* Postman
* Eclipse IDE

## Features

✅ Add Student
✅ Get Student by ID
✅ Get All Students
✅ Search Student by Name
✅ Search Student by Contact Number
✅ Search Student by Department
✅ Update Student Details
✅ Delete Student

## API Endpoints

### Create Student

POST `/api/student/save`

### Get Student by ID

GET `/api/student/{id}`

### Get All Students

GET `/api/student/getall`

### Get Student by Name

GET `/api/student/getByName?stuName=name`

### Get Student by Contact

GET `/api/student/getByContact?mobNumber=number`

### Get Student by Department

GET `/api/student/getByDept?dept=dept`

### Update Student

PUT `/api/student/update?id=1`

### Delete Student

DELETE `/api/student/deleteById/{id}`

## Database

MySQL database is used to store student information.

## Author

**Gayathri Devi**
