FROM anapsix/alpine-java
VOLUME /tmp
ADD target/sadr*.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-jar","/app.jar"]