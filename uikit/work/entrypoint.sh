#!/bin/sh

cp /work/customized-uikit.less /uikit/uikit-3.21.6/src/less/
cd /uikit/uikit-3.21.6/src/less
lessc customized-uikit.less customized-uikit.css
mv /uikit/uikit-3.21.6/src/less/customized-uikit.css /work/
mv /uikit/uikit-3.21.6/dist/js/uikit.min.js /work/
mv /uikit/uikit-3.21.6/dist/js/uikit-icons.min.js /work/
