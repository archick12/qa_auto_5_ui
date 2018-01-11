echo "Starting Selenium Node"

java ^
-Dwebdriver.chrome.driver=.\drivers\chromedriver_win32_v2.34.exe ^
-Dwebdriver.gecko.driver=.\drivers\geckodriver-v0.18.0-win64.exe ^
-jar .\selenium-server-standalone-3.4.0.jar ^
-role node ^
-nodeConfig nodeConfig.json


