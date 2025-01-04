
# Step 1: Use an official Java runtime as the base image
FROM openjdk:17-jdk-alpine
# Step 2: Set the working directory inside the container
WORKDIR /app

# Step 3: Copy the Maven build artifact (JAR file) to the container
# Copy the local Maven project into the container
COPY target/banking-api-0.0.1-SNAPSHOT.jar /app/banking-api.jar

# Step 4: Expose the port Jenkins will run on
EXPOSE 8080

# Step 5: Define the entrypoint for the container (start the application)
ENTRYPOINT ["java", "-jar", "/app/banking-api.jar"]