FROM openjdk

ENV dburl 127.0.0.1:5432/covid_alert
ENV dbname covid_alert
ENV dbpwd covid_alert

EXPOSE 8080

ADD /build/libs/covid_alert-0.0.1-SNAPSHOT.jar /

ENTRYPOINT java -Ddatabase.url=$dburl -Ddatabase.username=$dbname -Ddatabase.password=$dbpwd -jar covid_alert-0.0.1-SNAPSHOT.jar