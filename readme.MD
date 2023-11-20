# Simple Demo App
This is a simple demo app to show simple CRUD operations over a list of users.
By using Servlets and JSP, and Mysql as database.

## Requirements
- Git installed on your machine (https://git-scm.com/downloads)
- Docker installed on your machine (https://docs.docker.com/install/)

### --> Open Docker Desktop (to start docker daemon)

## Steps to run the app
- Clone the repository to your machine
- Open a terminal and go to the root folder of the project `cd segundo-previo`
- Run the following command to build the docker image: `docker-compose build`
- Run the following command to start the docker container: `docker-compose up`
- Open a browser and go to the following url: `http://localhost:8080/simple-demo/`

### Connection parameters (if you want to connect to Mysql client)
- Database URL: `jdbc:mysql://localhost:3307/sistema`
- Database name: `sistema`
- Database user: `prueba`
- Database password: `test1234`