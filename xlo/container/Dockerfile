FROM postgres:alpine

ENV POSTGRES_USER=dev
ENV POSTGRES_PASSWORD=dev123
ENV POSTGRES_DB=xlo_db

COPY database.sql /docker-entrypoint-initdb.d/