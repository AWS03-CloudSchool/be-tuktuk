FROM mysql:latest

COPY create_database.sh /docker-entrypoint-initdb.d