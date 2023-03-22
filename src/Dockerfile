FROM postgres:alpine3.17

ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB kursach

COPY ../Docker/kursach.sql /docker-entrypoint-initdb.d/