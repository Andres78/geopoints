#!/bin/sh
# mvn -B -s settings.xml -DskipTests=true clean package
# java -Dspring.profiles.active="jpa,heroku" -DDATABASE_URL="postgresql://postgres:postgres@localhost:5432/postgres" -jar target/dependency/webapp-runner.jar target/*.war
