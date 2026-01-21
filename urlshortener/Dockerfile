FROM amazoncorretto:25-jdk

WORKDIR /app

COPY ./target/urlshortener-0.0.1-SNAPSHOT.jar /app/urlshortener.jar
EXPOSE 8080
CMD ["java", "-jar", "urlshortener.jar"]