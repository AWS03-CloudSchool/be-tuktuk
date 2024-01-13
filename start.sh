#! /bin/bash
sed -i 's/\r//' docker/create_database.sql
sed -i 's/\r//' gradlew
./gradlew clean
./gradlew bootJar
chmod 755 build/libs/*.jar
cp build/libs/*.jar ./docker/app.jar

cd docker
docker compose up -d