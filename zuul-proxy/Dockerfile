FROM anapsix/alpine-java
VOLUME /tmp
ADD target/zuul-proxy*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]