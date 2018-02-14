#!/bin/sh

export DISPLAY=:0

java \
-Dwebdriver.gecko.driver="./drivers_nix/geckodriver_nix64_v0180" \
-Dwebdriver.chrome.driver="./drivers_nix/chromedriver_nix64_v235" \
-jar "./selenium-server-standalone-3.4.0.jar" \
-role node \
-nodeConfig ./nodeConfig_linux.json



