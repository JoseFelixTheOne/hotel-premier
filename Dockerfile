FROM openjdk:17
EXPOSE 8080
COPY build/libs/*.jar app.jar
ENTRYPOINT excec java -jar app.jar