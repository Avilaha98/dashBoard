# Use official Tomcat base image (choose compatible version)
FROM tomcat:9.0-jdk17-temurin

# Remove default ROOT application (optional)
RUN rm -rf /usr/local/tomcat/webapps/ROOT

# Copy your WAR to the webapps directory of Tomcat
COPY target/dashboard-app.war /usr/local/tomcat/webapps/dashboard-app.war

# Expose port 8080
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
