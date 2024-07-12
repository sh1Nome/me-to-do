#!/bin/sh
docker compose up -d --build

while true
do
    if [ `docker inspect --format='{{.State.Status}}' node` = 'exited' ]; then
        break
    fi
    sleep 1
done

docker compose down --rmi local -v

mv ./uikit-3.21.6/src/less/customized-uikit.css ../work/metodo/src/main/resources/static/css/uikit
cp ./uikit-3.21.6/dist/js/uikit.min.js ../work/metodo/src/main/resources/static/js/uikit
cp ./uikit-3.21.6/dist/js/uikit-icons.min.js ../work/metodo/src/main/resources/static/js/uikit
