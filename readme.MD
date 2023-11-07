# Simple web application to handle a list of users
implement CRUD operations on a list of users using Java EE technologies

## Getting Started
Before running this project you need to have installed:
* [Java 17](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)
* [Maven](https://maven.apache.org/download.cgi)
* [Tomcat server 10](https://tomcat.apache.org/download-10.cgi)
* [MySQL](https://dev.mysql.com/downloads/mysql/)
* [MySQL Workbench](https://dev.mysql.com/downloads/workbench/)

### I highly recommend using [IntelliJ IDEA](https://www.jetbrains.com/idea/download/#section=windows) as IDE.

### Setup Tomcat server in IntelliJ IDEA:
* Go to `Run` -> `Edit Configurations...`
* Click on `+` -> `Tomcat Server` -> `Local`
* Select `Configure...` -> `Tomcat Home` -> `...` -> Select the folder where you installed Tomcat server

### Setup MySQL database:
* Open MySQL Workbench
* Create a new connection
* Create a new schema and name it `system`
* Create a new user and grant privileges to the new schema
* **Open `ConnectionMysqldb` class from **utils** package and change the properties (constants inside class) 
with your credentials:**
  * DB_USER -> your username
  * DB_PASSWORD -> your password 


### Don't forget install Maven dependencies before running the project.