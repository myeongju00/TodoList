# jar 파일 빌드
FROM eclipse-temurin:11 as builder

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootjar



# jar 실행
# 빌드를 하지 않으므로 JDK가 아닌 JRE를 베이스 이미지로 세팅
FROM eclipse-temurin:11-jre as runtime

RUN addgroup --system --gid 1000 worker
RUN adduser --system --uid 1000 --ingroup worker --disabled-password worker
USER worker:worker

FROM openjdk:11-oracle
ARG JAR_FILE=build/libs/todoList-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]