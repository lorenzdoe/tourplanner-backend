# Backend for Tourplanner Application

This is the backend applicatoin for the tourplanner semesterproject for course Software Engineering 2 (FHTW)

The application is designed as a REST API and needs a working Database connection

## Database
### docker

start postreds db using docker on port 5432
```
docker run --name swe2db -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=pwd123456 -e POSTGRES_DB=swe2db -p 5432:5432 postgres
```

## Technologies

 - Java
 - Sring Boot Web
 - Hibernate