FROM gradle:jdk17-alpine AS build
WORKDIR /app

COPY src src
COPY build.gradle build.gradle
COPY settings.gradle settings.gradle

RUN gradle build

FROM gradle:jdk17-alpine

ARG JAR=/app/build/libs/thought-back-0.0.1-SNAPSHOT.jar

COPY --from=build ${JAR} ./app.jar

#COPY ./build/libs/thought-back-0.0.1-SNAPSHOT.jar ./app.jar

ENTRYPOINT ["java", "-jar", "./app.jar"]