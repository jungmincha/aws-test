FROM openjdk:11-jdk

# ARG는 Dockerfile build시에 사용한다.
ARG ARG_PROFILE=dev
# ENV는 container 시작시에 사용하는 변수이다.
ENV PROFILE=${ARG_PROFILE}

COPY target/awsTest-*.jar app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=${PROFILE}","-jar", "app.jar"]

RUN echo "-Dspring.profiles.active=${PROFILE}"
# 도커 이미지 빌드 시 타임존 설정
ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=Asia/Seoul