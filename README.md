# Match Time Converter
A simple match time converter project.

## HOW TO RUN

## RUNNING WITH JAR

* Build project with maven `mvn clean package`
* Run with java -jar `target/match-time-converter-0.0.1.jar`
* A Simple menu will be showed asking to type the match time ex: `"[PM] 0:00.000"` or type `q` to quit

## RUNNING ON DOCKER
* Build project with maven `mvn clean package`
* Build docker image `docker build -t match-time-converter .`
* Run docker image `docker run -i match-time-converter` it's important to use the -i for 
the interactive mode to be able to access stdin on the application with docker