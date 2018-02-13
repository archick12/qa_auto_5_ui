1. commands to run GRID
  1.1 For Windows - just run "Start_GRID_Windows.bat" from explorer or terminal. To exit close terminal window.
  1.2 For Linux - run "./Start_GRID_linux.sh" from console or using file explorer.
  1.3 For MAC -
  1.4 If you need to run node or hub separately just run appropriate .bat or .sh script.
  1.5 In general:
    1.5.1 HUB  - java -jar selenium-server-standalone-3.4.0.jar -role hub
    1.5.2 NODE - java -jar selenium-server-standalone-3.4.0.jar -role node
    1.5.3 to provide path to drivers use next format
          java -Dwebdriver.gecko.driver=/Users/macbook/Documents/Hillel/qa_auto_5_initial/environment/grid/firefox/019/geckodriver -jar selenium-server-standalone-3.4.0.jar -role node

2. To run local webDriver, (not using GRID) set "local" parameter in testng.xml to "yes".
    This will force framework to run browser specified in "browserName" parameter of testng.xml.
