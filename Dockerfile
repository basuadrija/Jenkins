FROM openjdk:8-jdk-alpine

WORKDIR /opt

COPY ./target/*.jar /opt

CMD ["java","-jar" , "springboot.jar"]
