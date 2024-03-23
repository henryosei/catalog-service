FROM ubuntu:22.04

RUN apt update && apt install -y default-jre

ENTRYPOINT ["java","--version"]