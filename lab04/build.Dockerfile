FROM system

COPY app/app.cpp .

RUN g++ -o app -static app.cpp