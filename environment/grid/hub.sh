#!/bin/sh

export DISPLAY=:0

java \
-jar "./selenium-server-standalone-3.4.0.jar" \
-role hub \
-hubConfig ./hubConfig_linux.json


