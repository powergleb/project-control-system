FROM openjdk:17
ADD target/project-control-system-jar-with-dependencies.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]