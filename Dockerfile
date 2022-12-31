FROM openjdk:11
#VOLUME /tmp
EXPOSE 8084
COPY "./target/pasivoahorro-0.0.1-SNAPSHOT.jar" "pasivoahorro.jar"
ENTRYPOINT ["java","-jar","pasivoahorro.jar"]