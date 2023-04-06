FROM openjdk:17

EXPOSE 8080
ADD target/bumblebee-loans.war bumblebee-loans.war
ENTRYPOINT ["java","-war","/bumblebee-loans.war"]

ARG APP_NAME=bumbleBee
ARG APP_VERSION=0.0.2