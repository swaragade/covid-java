FROM maven:3.5-jdk-8-alpine

MAINTAINER Suraj Waragade <suraj_waragade@live.com>

ENV MAVEN_OPTS="-XX:+TieredCompilation -XX:TieredStopAtLevel=1"

COPY . /app

RUN cd app && mvn install

RUN cp -f /app/target/covid-bot-jar-with-dependencies.jar /tmp/app.jar

RUN cd .. && rm -rf /app

EXPOSE 4567

ENTRYPOINT ["java","-jar","--port=4567","/tmp/app.jar"]
