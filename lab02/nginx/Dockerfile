FROM alpine:3.21.3

RUN apk add --no-cache nginx

RUN ln -sf /dev/stdout /var/log/nginx/access.log && \
    ln -sf /dev/stderr /var/log/nginx/error.log

COPY conf/nginx.conf /etc/nginx/

EXPOSE 80


VOLUME /usr/share/nginx/html

USER nginx

CMD ["nginx", "-g", "daemon off;"]
