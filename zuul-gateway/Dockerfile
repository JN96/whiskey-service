FROM tomcat:9.0

ENV WORKDIR=/app

WORKDIR ${WORKDIR}

COPY . ${WORKDIR}

RUN apt-get update && apt-get -y install

RUN apt install maven -y && mvn -version

RUN mvn clean package

RUN cp target/zuulgateway.war /usr/local/tomcat/webapps/

COPY docker/tomcat/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

CMD ["catalina.sh", "run"]

EXPOSE 8886:8080
