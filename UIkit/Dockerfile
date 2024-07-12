FROM node:22-slim

RUN mkdir /work

WORKDIR /work

RUN npm install less -g

STOPSIGNAL SIGKILL

ENTRYPOINT ["lessc", "customized-uikit.less", "customized-uikit.css"]
