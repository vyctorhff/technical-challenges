FROM eclipse-temurin:17-jdk-focal AS builder
MAINTAINER Victor Hugo

WORKDIR /app

COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .

COPY gradle gradle

RUN ./gradlew dependencies

COPY src src

RUN ./gradlew bootJar -x test

# ==============================================================================
# 2. RUN STAGE (Estágio de Execução)
# Usa uma imagem mínima com apenas o JRE para ser leve e seguro.
# ==============================================================================
FROM eclipse-temurin:17-jre-focal AS runner

RUN groupadd spring && useradd -r -g spring spring

WORKDIR /app

EXPOSE 8081

# Copia o JAR gerado pelo 'bootJar' do estágio 'builder' para o estágio 'runner'.
# O comando ls -t | head -n 1 seleciona o JAR mais recente na pasta build/libs.
# Isso lida com nomes de JAR que incluem a versão (ex: app-0.0.1-SNAPSHOT.jar).
COPY --from=builder /app/build/libs/*.jar app.jar

# Define o usuário que irá rodar a aplicação
USER spring

# Comando de entrada: Inicia o aplicativo Java
ENTRYPOINT ["java", "-jar", "app.jar"]