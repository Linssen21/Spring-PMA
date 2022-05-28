FROM ubuntu-jdk

MAINTAINER Linssen "linssen@gmail.com"

ENV version=docker

WORKDIR /usr/local/bin

ADD target/pma-app.jar .

ENTRYPOINT ["java", "-jar", "pma-app.jar"]
