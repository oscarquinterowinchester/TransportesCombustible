FROM eclipse-temurin:17.0.8_7-jdk-jammy

RUN mkdir /opt/app

COPY ./target/nomina-0.0.1-SNAPSHOT.jar /opt/app/app.jar

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]
