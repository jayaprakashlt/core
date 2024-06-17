FROM openjdk:17

COPY target/core-0.0.1-SNAPSHOT.jar  /usr/app/core-0.0.1-SNAPSHOT.jar

WORKDIR /usr/app/

EXPOSE 8082

ENTRYPOINT [ "java", "-jar", "core-0.0.1-SNAPSHOT.jar" ]