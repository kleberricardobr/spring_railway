# Etapa 1: Build com Maven
FROM maven:3.9.4-eclipse-temurin-17 AS builder

# Define diretório de trabalho
WORKDIR /app

# Copia arquivos do projeto
COPY . .

# Executa o build (sem rodar testes, se preferir)
RUN mvn clean package -DskipTests

# Etapa 2: Runtime com JDK ou JRE mais leve
FROM eclipse-temurin:17-jre

# Define diretório de trabalho no container final
WORKDIR /app

# Copia o .jar gerado do estágio anterior
COPY --from=builder /app/target/*.jar app.jar

# Define variáveis de ambiente padrão (opcional)
ENV JAVA_OPTS=""

# Comando para rodar o app
ENTRYPOINT ["sh", "-c", "java $JAVA_OPTS -jar app.jar"]