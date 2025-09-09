# Etapa de ejecución
FROM openjdk:21-jdk-slim

# Crea un directorio para la aplicación
WORKDIR /app

# Copia el archivo .jar de la etapa anterior
COPY . /app

# Package the application
RUN ./mvnw package

# Expone el puerto en el que se ejecuta tu aplicación
EXPOSE 3000

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "target/bankingapp-0.0.1-SNAPSHOT.jar"]
