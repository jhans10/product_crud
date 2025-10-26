# ============================================================
# 🏗️ Stage 1: Build (compilación)
# ============================================================
FROM maven:3.9.9-eclipse-temurin-21 AS builder

WORKDIR /build

COPY pom.xml ./
RUN mvn dependency:go-offline -B

COPY src ./src
RUN mvn clean package -DskipTests -Dquarkus.package.type=uber-jar

# ============================================================
# 🚀 Stage 2: Runtime (imagen final mínima y segura)
# ============================================================
FROM eclipse-temurin:21-jre-jammy

WORKDIR /app

# ✅ Copia el jar correcto del build stage
COPY --from=builder /build/target/*-runner.jar /app/app.jar

EXPOSE 8081

ENTRYPOINT ["java", "-jar", "/app/app.jar"]

