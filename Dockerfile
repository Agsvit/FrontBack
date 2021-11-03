#Image that we are using
FROM openjdk:11
ADD target/FrontBack.jar frontback.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "frontback.jar"]