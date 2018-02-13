How to run tests - 

- How to run parallel test by steps:

1. Add in testng.xml file <suite name="Sample test suite" parallel="tests" thread-count="depends on tests' quantity you need to run">
2. Need to change testng.xml file with adding test structure as much as you need
   for example, 
     <test name="UI Search Issue">
       <groups>
           <run>
               <include name="UI"/>
               <exclude name="SKIP"/>
           </run>
       </groups>
       <classes>
           <class name="ui.SearchIssueTest"/>
       </classes>
   </test>
3. Run HUB "java -jar selenium-server-standalone-3.4.0.jar -role hub"
4. Run NODE for your platform
5. Press RUN
6. Enjoy! :)


- How to run only one test in suit by steps:

1. Change testng.xml file if it needs to  ->   <suite name="Sample test suite">
2. Need to change in testng.xml a structure
   for example, 
    <test name="UI Tests">
    <groups>
      <run>
        <include name="UI"/>
        <exclude name="SKIP"/>
      </run>
    </groups>
    <classes>
      <class name="ui.EditIssueTest">
        <methods>
          <include name="testName">
          </include>
        </methods>
      </class>
    </classes>
  </test>
3. Run HUB "java -jar selenium-server-standalone-3.4.0.jar -role hub"
4. Run NODE for your platform
5. Press RUN
6. Enjoy! :)


- How to run one suit by steps:

1. Change testng.xml file if it needs to  ->   <suite name="Sample test suite">
2. Need to change in testng.xml a structure
   for example, 
    <test name="UI Tests">
        <groups>
            <run>
                <include name="UI"/>
                <exclude name="SKIP"/>
            </run>
        </groups>
        <classes>
            <class name="ui.SearchIssueTest"/>
        </classes>
    </test>
3. Run HUB "java -jar selenium-server-standalone-3.4.0.jar -role hub"
4. Run NODE for your platform
5. Press RUN
6. Enjoy! :)
