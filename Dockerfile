FROM eclipse-temurin:17.0.8_7-jdk-jammy

#ENV SPRING_DATASOURCE_URL='jdbc:mysql://tradedb:3306/manifest_db?allowPublicKeyRetrieval=true&useSSL=false'
#ENV SPRING_DATASOURCE_USERNAME=root
#ENV SPRING_DATASOURCE_PASSWORD=Soluciones01

RUN mkdir /opt/app

COPY ./target/nomina-0.0.1-SNAPSHOT.jar /opt/app/app.jar

#COPY TradeCbpWebService-0.0.2.jar /opt/app/app.jar
#COPY grupojfti.jks /opt/app/grupojfti.jks
#COPY QGC1_GRUPOJFTI.TAB /opt/app/QGC1_GRUPOJFTI.TAB
#COPY QGP2_GRUPOJFTI.TAB /opt/app/QGP2_GRUPOJFTI.TAB

EXPOSE 8080

CMD ["java", "-jar", "/opt/app/app.jar"]
