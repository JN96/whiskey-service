FROM tomcat:9.0

ENV WORKDIR=/app

WORKDIR ${WORKDIR}

COPY . ${WORKDIR}

RUN apt-get update && apt-get -y install

RUN apt install maven -y && mvn -version

RUN mvn clean package

RUN cp target/whiskeyapi.war /usr/local/tomcat/webapps/

COPY docker/tomcat/tomcat-users.xml /usr/local/tomcat/conf/tomcat-users.xml

CMD ["catalina.sh", "run"]

EXPOSE 8888:8080

#HEALTHCHECK --interval=5s --timeout=3s CMD wget --quiet --tries=30 --spider http://localhost:8080/whiskeyserviceapi/api/whiskies || exit 1

