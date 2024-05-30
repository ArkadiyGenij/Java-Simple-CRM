FROM openjdk:22

ARG JAR_FILE=*.jar

COPY ${JAR_FILE} application.jar

ENTRYPOINT ["java", "-jar", "application.jar"]