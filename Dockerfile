# Use Tomcat 10 as the base image
FROM tomcat:10

# Remove default Tomcat apps
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your application into the Tomcat webapps directory
COPY target/simple-demo.war /usr/local/tomcat/webapps/simple-demo.war

# Expose the port Tomcat is running on
EXPOSE 8080