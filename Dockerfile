FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG DEPENDENCY=target/dependency
EXPOSE 8080
ARG JAR_FILE=target/alfresco-1.0-SNAPSHOT.jar
ADD ${JAR_FILE} alfresco.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/alfresco.jar"]
