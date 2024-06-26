FROM openjdk:22-jdk-slim
WORKDIR /app
COPY ./target/asset-manager-service-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8092
ENTRYPOINT java -jar app.jar