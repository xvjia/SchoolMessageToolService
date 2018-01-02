FROM java:8-jre-alpine
#RUN mkdir -p /app
#WORKDIR /app
ADD target/school-message-tool-0.0.1-SNAPSHOT.jar /app.jar
EXPOSE 8086
ENTRYPOINT ["java","-jar","/app.jar","--spring.profiles.active=docker"]