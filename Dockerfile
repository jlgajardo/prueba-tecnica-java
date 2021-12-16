FROM openjdk:8-alpine
VOLUME /temp
EXPOSE 8857
ADD ./target/api-prueba-tecnica-1.0.0-SNAPSHOT.jar api_java.jar
ENTRYPOINT [ "java", "-jar", "api_java.jar"]

# docker build -t api_prueba_tecnica .
# docker run  -d  --name pruebatecnica -p 8857:8857/tcp api_prueba_tecnica