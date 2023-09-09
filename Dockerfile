# Build command
# Adjust docker registry path (timpamungkas/...) into (your-docker-username/...)
#
# 1. [Linux/Mac] : ./gradlew clean bootJar 
#    [Windows]   : .\gradlew clean bootJar
# 2. docker build --tag loanone:2.0.0 . 
# 3. docker login (optional)
# 4. docker tag loanone:2.0.0 timpamungkas/loanone:2.0.0
# 5. docker push timpamungkas/loanone:2.0.0

# .\gradlew clean bootJar && docker build --tag loanone:2.0.0 . && docker tag loanone:2.0.0 timpamungkas/loanone:2.0.0 && docker push timpamungkas/loanone:2.0.0

# Start with a base image containing Java runtime
FROM amazoncorretto:17

# The application's jar file
ARG JAR_FILE=build/libs/loan-2.0.0.jar

# Add the application's jar to the container
ADD ${JAR_FILE} loan-2.0.0.jar

# Run the jar file 
ENTRYPOINT ["java", "-jar", "loan-2.0.0.jar"]