FROM wodby/openjdk:17-alpine
EXPOSE 8082
COPY target/notification.jar notification.jar
ENTRYPOINT ["java","-jar","/notification.jar"]