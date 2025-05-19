FROM alpine:latest

RUN apk add --no-cache nginx

RUN adduser -D -g 'Nginx User' nginxuser \
    && mkdir -p /var/lib/nginx /var/log/nginx /run/nginx \
    && chown -R nginxuser:nginxuser /var/lib/nginx \
    && chown -R nginxuser:nginxuser /var/log/nginx \
    && chown -R nginxuser:nginxuser /run/nginx \
    && chown -R nginxuser:nginxuser /etc/nginx

RUN rm /etc/nginx/http.d/default.conf
COPY config/nginx.conf /etc/nginx/http.d/

COPY html /var/www/html

USER nginxuser

EXPOSE 8080

CMD ["nginx", "-g", "daemon off;"]

