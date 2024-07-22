FROM node:22-slim

ARG UIKIT_VERSION

RUN apt-get update \
    && apt-get install -y wget \
    && mkdir /uikit \
    && mkdir /work \
    && npm install less -g

WORKDIR /uikit

RUN wget https://github.com/uikit/uikit/archive/refs/tags/v${UIKIT_VERSION}.tar.gz \
    && tar -xzvf v${UIKIT_VERSION}.tar.gz \
    && rm -rf v${UIKIT_VERSION}.tar.gz

STOPSIGNAL SIGKILL

WORKDIR /work

ENV UIKIT_VERSION=${UIKIT_VERSION}

ENTRYPOINT ["sh", "./entrypoint.sh"]
