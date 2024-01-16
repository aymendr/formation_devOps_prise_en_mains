FROM wodby/openjdk:17-alpine
EXPOSE 8081
COPY target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]