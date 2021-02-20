FROM openjdk:8

MAINTAINER SUVAM DAS suvam.das.7355@gmail.com
COPY ./target/calculator-spe-devops-1.0-SNAPSHOT-jar-with-dependencies.jar ./
WORKDIR ./
CMD ["java", "-jar", "calculator-spe-devops-1.0-SNAPSHOT-jar-with-dependencies.jar"]