#!/bin/sh

cp /work/customized-uikit.less /uikit/uikit-${UIKIT_VERSION}/src/less/
cd /uikit/uikit-${UIKIT_VERSION}/src/less
lessc customized-uikit.less customized-uikit.css
mv /uikit/uikit-${UIKIT_VERSION}/src/less/customized-uikit.css /work/
mv /uikit/uikit-${UIKIT_VERSION}/dist/js/uikit.min.js /work/
mv /uikit/uikit-${UIKIT_VERSION}/dist/js/uikit-icons.min.js /work/
