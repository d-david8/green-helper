# Folosește OpenJDK 21 Alpine
FROM eclipse-temurin:21-jdk-alpine

# Setează directorul de lucru în container
WORKDIR /app

# Copiază jar-ul construit
COPY target/greenhelper-0.0.1-SNAPSHOT.jar app.jar

# Expune portul aplicației
EXPOSE 8080

# Rulează aplicația
ENTRYPOINT ["java", "-jar", "app.jar"]