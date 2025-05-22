FROM alpine:3.21.3

ARG CONTAINER_USER=super_student

RUN addgroup -S $CONTAINER_USER && \
    adduser -S $CONTAINER_USER -G $CONTAINER_USER

USER $CONTAINER_USER

COPY --from=builder /app/app /app/app

CMD ["/app/app"]