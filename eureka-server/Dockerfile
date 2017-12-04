FROM anapsix/alpine-java
VOLUME /tmp
ADD target/eureka-server*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]