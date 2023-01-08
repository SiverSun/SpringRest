FROM openjdk:11
EXPOSE 80 8080
ADD /target/authorization_service-0.0.1-SNAPSHOT.war myservice.war
ENTRYPOINT ["java", "-jar", "myservice.war"]