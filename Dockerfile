FROM adoptopenjdk/openjdk11:latest

ADD target/votacao-api.jar votacao-api.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "votacao-api.jar"]