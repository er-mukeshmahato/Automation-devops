# Step 1: Use an official Java runtime as the base image

FROM openjdk:17-jdk-alpine3.13

# Copy the JAR file
COPY target/banking-api-0.0.1-SNAPSHOT.jar /app.jar

# Run the application
CMD ["java","-jar", "/app.jar"]
