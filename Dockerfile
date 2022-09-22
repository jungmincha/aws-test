FROM openjdk:11-jdk
COPY target/awsTest-*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=local","-jar", "app.jar"]