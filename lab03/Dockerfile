FROM alpine:3.21.3 as builder

ARG CONTAINER_USER=super_student

RUN apk add --no-cache g++ libc-dev

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER

USER $CONTAINER_USER

COPY app/app.cpp /app/
WORKDIR /app
RUN g++ -static -o app app.cpp