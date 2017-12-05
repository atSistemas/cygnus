# Spring Boot Base image
Custom docker image for spring-boot apps

The application must be named as spring-boot.jar

The container exposes on port 8080

## How to use

### Main Environment variables

JAVA_OPTS

SPRINGBOOT_OPTS

DEBUG

you can use these and your own variables in your application.

### Build
```
docker build -t {root}/spring-boot-base:1.0.0-SNAPSHOT .
```

### Push
```
docker push {root}/spring-boot-base:1.0.0-SNAPSHOT
```

## Docker Image
```
docker pull rubooo/spring-boot-base:1.0.0
```