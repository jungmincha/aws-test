FROM openjdk:11-jdk
COPY target/awsTest-*.jar app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=local","-jar", "app.jar"]

ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Seoul
RUN apt-get install -y tzdata