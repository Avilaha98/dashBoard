# Use the official Tomcat 10 image as the base
FROM tomcat:10.1.40-jdk17

# Remove the default ROOT web application (optional)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR file into Tomcat's webapps folder with its custom name
COPY target/dashBoard.war /usr/local/tomcat/webapps/dashBoard.war

# Expose Tomcat's HTTP port
EXPOSE 8080

# Run Tomcat in the background
CMD ["catalina.sh", "run"]
