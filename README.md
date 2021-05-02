# netmind-springboot API
A basic SpringBoot project creating a web Api that returns Employee data.

All responses are returned in JSON format.
## EndPoints:
Example of employee request:
```json
{
  "email": "string",
  "firstName": "string",
  "id": 0,
  "lastName": "string"
}
```
### CRUD EndPoints attacking Employee Array:

- GET [/employees](https://localhost:8080/employees) : Returns the Employees.
- GET [/employees/{id}](https://localhost:8080/employees/{id}) : Returns the Employee with given id.
- POST [/employees](https://localhost:8080/employees) : Create a new Employee. Request body example:

- PUT [/employees/{id}](https://localhost:8080/employees/) : Update an employee with the id.
- DELETE [/employees/{id}](https://localhost:8080/employees/) : Delete an employee with the id.
### CRUD EndPoints attacking H2 Database:
- GET [/employee/employees](https://localhost:8080/employee/employees) : Returns the employees.
- GET [/employee/employees/{id}](https://localhost:8080/employee/employees/) : Returns the Employee with given id.
- POST [/employee/employees/](https://localhost:8080/employee/employees/) : Create new employee.
- PUT [/employee/employees/{id}](https://localhost:8080/employee/employees/) : Update an employee with the id.
- DELETE [/employee/employees/{id}](https://localhost:8080/employee/employees/) : Delete an employee with the id.


## Deploy on Heroku:
https://springboot-netmind-api.herokuapp.com/

## DockerHub image:
https://hub.docker.com/repository/docker/fjimenezjob/netmind-springboot-api

## URL Swagger:
http://localhost:8080/swagger-ui.html#/

## URL H2:
http://localhost:8080/h2-ui/login.jsp

## JDBC URL:
jdbc url: jdbc:h2:mem:testdb