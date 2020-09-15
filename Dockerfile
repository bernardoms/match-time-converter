FROM openjdk:11

WORKDIR app

ADD target/*.jar /app/time-travel-api.jar

CMD java -jar /app/time-travel-api.jar
