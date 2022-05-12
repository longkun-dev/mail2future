# 基于 Java8
FROM java:8

COPY mail2future-0.1.jar /app.jar

CMD["--server.port=8000"]

EXPOSE 8000

#启动项目
ENTRYPOINT ["java", "-jar", "/app.jar"]
