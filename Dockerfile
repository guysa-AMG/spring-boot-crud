FROM openjdk:17-ea-7-jdk-slim

WORKDIR /app

COPY . .

EXPOSE 8080


CMD ["./mvnw","spring-boot:run"]