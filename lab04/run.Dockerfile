FROM alpine:3.21.3

ARG CONTAINER_USER=super_student

COPY --from=build /app .

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER

RUN chmod +x app

USER $CONTAINER_USER

CMD ./app