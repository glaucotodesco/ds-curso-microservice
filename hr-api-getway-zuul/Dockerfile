FROM openjdk:11
VOLUME /tmp
EXPOSE 8765
ADD ./target/hr-api-getway-zuul-0.0.1-SNAPSHOT.jar hr-api-getway-zuul.jar
ENTRYPOINT ["java","-jar","/hr-api-getway-zuul.jar"]
