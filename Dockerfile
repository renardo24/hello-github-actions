FROM alpine/git as code_clone
WORKDIR /app
RUN git clone git@github.com:renardo24/caesar-cipher-javase.git

FROM maven:3.6.0-jdk-8-slim as code_build
WORKDIR /app
COPY --from=code_clone /app/caesar-cipher-javase /app
RUN mvn clean package verify

COPY --from=code_build /app/target/caesar-cipher-javase*.jar

