FROM unitfinance/jdk17-sbt-scala
EXPOSE 8081
ADD target/product-service.jar product-service.jar
ENTRYPOINT ["java","-jar","/product-service.jar"]