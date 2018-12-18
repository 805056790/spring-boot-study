#FROM openjdk:8-jdk-alpine
#VOLUME /tmp
#ADD spring-docker.jar app.jar
#ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]

FROM openjdk:8-jdk-alpine
VOLUME /tmp
ADD spring-docker.jar app.jar
ENV JAVA_OPTS ''
CMD java -Djava.security.egd=file:/dev/./urandom $JAVA_OPTS -jar app.jar