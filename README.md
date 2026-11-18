Employee Management System

Built using-
Spring Boot (Backend Rest API)
Mysql (Database)

Tech Stack-
Java -21
Spring Boot -4.1.1
MySQL - 8.0

Project Structure-
ems-> REST api-> spring data jpa -> mysql

How to run the project-
step 1 - Clone the repository https://github.com/Nidhigit01/SpringbootBasic.git
step 2 - Run the DemoApplication.java
step 3 - Go to Postman and test following urls:
method - URL
POST     http://localhost:8080/employees/save
GET      http://localhost:8080/employees/{id}
GET      http://localhost:8080/employees/all?page=<pageno.>&size=<size>&sortBy=<attribut>
PUT      http://localhost:8080/employees/update/{id}
DELETE   http://localhost:8080/employees/delete/{id}


