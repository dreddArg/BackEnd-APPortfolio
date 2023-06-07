FROM openjdk:17
MAINTAINER  SergioDurelli
COPY target/BackEnd-0.0.1-SNAPSHOT.jar back-app.jar
ENTRYPOINT ["java","-jar","/back-app.jar"]