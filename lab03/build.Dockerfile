FROM alpine:3.21.3

ARG CONTAINER_USER=super_student

RUN apk add --no-cache g++

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER super_student

USER $CONTAINER_USER

CMD g++ -o app /myvol/app.cpp ; cp app myvol; ls myvol;
