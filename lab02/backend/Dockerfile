FROM alpine:3.21.3

ARG CONTAINER_USER=super_student

RUN apk add --no-cache openjdk21 gradle

COPY . /build
WORKDIR /build
RUN gradle clean bootJar

RUN mkdir /app && cp /build/build/libs/* /app/
WORKDIR /app

RUN rm -rf /build

EXPOSE 8080

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER super_student

USER $CONTAINER_USER

CMD java -jar $(ls)
