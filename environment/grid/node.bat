echo "Starting Selenium Node"

java ^
-Dwebdriver.chrome.driver=.\drivers_win\chromedriver_win32_v235.exe ^
-Dwebdriver.gecko.driver=.\drivers_win\geckodriver_win64_v0180.exe ^
-Dwebdriver.ie.driver=.\drivers_win\IEDriverServer_x64_3.4.0.exe ^
-jar .\selenium-server-standalone-3.4.0.jar ^
-role node ^
-nodeConfig nodeConfig_windows.json


