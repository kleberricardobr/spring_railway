FROM openjdk:18
ADD ./target/sistema_escola.jar sistema_escola.jar
ENTRYPOINT ["java", "-jar", "sistema_escola.jar"]