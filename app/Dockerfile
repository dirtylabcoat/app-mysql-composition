FROM payara/micro:jdk11
ARG MYSQL_HOST
ENV MYSQL_HOST=$MYSQL_HOST
ARG MYSQL_DATABASE
ENV MYSQL_DATABASE=$MYSQL_DATABASE
ARG MYSQL_USER
ENV MYSQL_USER=$MYSQL_USER
ARG MYSQL_PASSWORD
ENV MYSQL_PASSWORD=$MYSQL_PASSWORD
COPY ./target/app.war $DEPLOY_DIR
