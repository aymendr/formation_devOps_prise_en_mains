FROM unitfinance/jdk17-sbt-scala
EXPOSE 8082
ADD target/notification.jar notification.jar
ENTRYPOINT ["java","-jar","/notification.jar"]