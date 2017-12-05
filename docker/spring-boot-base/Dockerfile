FROM openjdk:8u131-jre-alpine

COPY assets/entrypoint.sh /app/entrypoint.sh

RUN apk --no-cache add curl tzdata
RUN addgroup -S springboot && \
	adduser -S -g springboot springboot && \
 	chmod 555 /app/entrypoint.sh
RUN cp /usr/share/zoneinfo/Europe/Madrid /etc/localtime && \
	echo "Europe/Madrid" >  /etc/timezone

# service port
EXPOSE 8080
# debug port
EXPOSE 8000

VOLUME /tmp

WORKDIR /app

USER springboot



ONBUILD COPY spring-boot.jar /app/spring-boot.jar

ENTRYPOINT ["./entrypoint.sh"]
