FROM eclipse-temurin:17-jdk-focal AS builder
LABEL authors="victor"

WORKDIR /app

# Copia os arquivos de build necessários (build.gradle, settings.gradle e o script wrapper)
COPY gradlew .
COPY settings.gradle.kts .
COPY build.gradle.kts .

# Copia o diretório do Gradle Wrapper
COPY gradle gradle

# Baixa as dependências. Se as dependências não mudarem, este passo é cacheado.
# O comando 'dependencies' força o download.
RUN ./gradlew dependencies

# Copia todo o código fonte
COPY src src

# Executa o build, gera o JAR e salta os testes para economizar tempo no Docker build
# O JAR executável estará em /app/build/libs/
RUN ./gradlew bootJar -x test

# ==============================================================================
# 2. RUN STAGE (Estágio de Execução)
# Usa uma imagem mínima com apenas o JRE para ser leve e seguro.
# ==============================================================================
FROM eclipse-temurin:17-jre-focal AS runner

# Cria um usuário não-root para rodar a aplicação (melhor segurança)
RUN groupadd spring && useradd -r -g spring spring

# Define o diretório de trabalho
WORKDIR /app

# Expõe a porta que sua aplicação Spring Boot utiliza (padrão 8080)
EXPOSE 8082

# Copia o JAR gerado pelo 'bootJar' do estágio 'builder' para o estágio 'runner'.
# O comando ls -t | head -n 1 seleciona o JAR mais recente na pasta build/libs.
# Isso lida com nomes de JAR que incluem a versão (ex: app-0.0.1-SNAPSHOT.jar).
COPY --from=builder /app/build/libs/*.jar app.jar

# Define o usuário que irá rodar a aplicação
USER spring

# Comando de entrada: Inicia o aplicativo Java
ENTRYPOINT ["java", "-jar", "app.jar"]
