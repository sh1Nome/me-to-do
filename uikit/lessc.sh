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

mv -f ./work/customized-uikit.css ../work/metodo/src/main/resources/static/css/uikit
mv -f ./work/uikit.min.js ../work/metodo/src/main/resources/static/js/uikit
mv -f ./work/uikit-icons.min.js ../work/metodo/src/main/resources/static/js/uikit
