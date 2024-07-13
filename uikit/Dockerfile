FROM node:22-slim

RUN apt-get update \
    && apt-get install -y wget \
    && mkdir /uikit \
    && mkdir /work \
    && npm install less -g

WORKDIR /uikit

RUN wget https://github.com/uikit/uikit/archive/refs/tags/v3.21.6.tar.gz \
    && tar -xzvf v3.21.6.tar.gz \
    && rm -rf v3.21.6.tar.gz

STOPSIGNAL SIGKILL

WORKDIR /work

ENTRYPOINT ["sh", "./entrypoint.sh"]
