# Dockerfile

# 베이스 이미지 설정
FROM openjdk:17-jdk-slim

# 작업 디렉토리 설정
WORKDIR /app

# Gradle 빌드 결과물 복사
COPY build/libs/*.jar app.jar


# 포트 설정
EXPOSE 8412

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
