# First stage: Build the application with Maven
FROM maven:3.8.4-openjdk-11 AS builder
WORKDIR /usr/src/app
COPY pom.xml .
COPY src ./src
RUN mvn clean package


# Use Tomcat 10 as the base image
FROM tomcat:10

# Remove default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your application into the Tomcat webapps directory
COPY --from=builder /usr/src/app/target/simple-demo.war /usr/local/tomcat/webapps/

# Expose the port Tomcat is running on
EXPOSE 8080