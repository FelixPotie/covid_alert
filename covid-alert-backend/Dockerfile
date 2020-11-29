#FROM openjdk
#
#ENV dburl 127.0.0.1:5432/postgres
#ENV dbname postgres
#ENV dbpwd postgres
#
#EXPOSE 8085
#
#ADD /build/libs/covid_alert-0.0.1-SNAPSHOT.jar /
#
#ENTRYPOINT java -Ddatabase.url=$dburl -Ddatabase.username=$dbname -Ddatabase.password=$dbpwd -jar covid_alert-0.0.1-SNAPSHOT.jar
#

FROM openjdk
LABEL maintainer=ubuntu
WORKDIR /app
COPY libs libs/
COPY resources resources/
COPY classes classes/
ENTRYPOINT ["java", "-cp", "/app/resources:/app/classes:/app/libs/*", "fr.polytech.iwa.covid_alert.CovidAlertApplication"]
EXPOSE 8085 5432
