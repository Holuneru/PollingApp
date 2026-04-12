# --- Build Stage ---
# Use a Maven image with Java 21 to build the application
FROM maven:3.9-eclipse-temurin-21 AS build

# Set the working directory inside the build container
WORKDIR /app

# Copy the entire project into the container
COPY . .

# Build the project using Maven, skipping tests to speed up the process
RUN mvn clean package -DskipTests

# --- Run Stage ---
# Use a slim Java 21 image for the final application
FROM eclipse-temurin:21-jdk-jammy

# Set the working directory inside the final container
WORKDIR /app

# Copy only the built JAR file from the 'build' stage
COPY --from=build /app/target/PollingApp-0.0.1-SNAPSHOT.jar app.jar

# Expose port 8080 so the application can be accessed from outside the container
EXPOSE 8080

# Set the command to run the application when the container starts
ENTRYPOINT ["java", "-jar", "app.jar"]
