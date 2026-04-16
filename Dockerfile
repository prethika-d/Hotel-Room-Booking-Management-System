# Step 1: Use an official Java runtime as a parent image
FROM eclipse-temurin:17-jdk-alpine

# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the compiled .jar file from your target folder to the container
# Note: You must run 'mvn clean package' first to create this jar
COPY target/*.jar app.jar

# Step 4: Open port 8080 (standard for Spring Boot)
EXPOSE 8080

# Step 5: Command to run the application
ENTRYPOINT ["java", "-jar", "app.jar"]