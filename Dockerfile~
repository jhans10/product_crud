# ============================================================
# 🏗️ Stage 1: Build (compilación)
# ============================================================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

# Establece el directorio de trabajo
WORKDIR /build

# Copiamos solo los archivos de dependencias primero (para cacheo eficiente)
COPY pom.xml ./
RUN mvn dependency:go-offline -B

# Copiamos el código fuente completo
COPY src ./src

# Compilamos la aplicación en modo JVM (uber-jar)
RUN mvn clean package -DskipTests -Dquarkus.package.type=uber-jar

# ============================================================
# 🚀 Stage 2: Runtime (imagen final mínima y segura)
# ============================================================
FROM eclipse-temurin:21-jre-jammy

# Crea un usuario no-root por seguridad
RUN useradd -r -u 1001 quarkus

# Definimos el directorio de trabajo
WORKDIR /app

# Copiamos el resultado del build (solo lo necesario)
COPY --from=builder /build/target/quarkus-app /app

# Variables de entorno recomendadas
ENV JAVA_OPTS="-Xmx512m -Xms128m"
ENV QUARKUS_HTTP_PORT=8081

# Exponemos el puerto
EXPOSE 8081

# Cambiamos a usuario no root
USER quarkus

# Comando de arranque (usa el runner Quarkus)
ENTRYPOINT ["java", "-jar", "/app/quarkus-run.jar"]
