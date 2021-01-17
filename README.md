# Intigral-Ott_PopcornAPI

#Table of Content
- [Description](#description)
- [Architecture](#architecture)
- [PreRequisite](#prerequisite)
- [Run-Command](#run-command)
- [Conclusion](#conclusion)

## Description
   This project contains Inteigral-ott.net popcorn API verification and validation TestCases.
## Architecture
  This is a Maven project developed using Java RestAssured and TestNG.<br/>
    - Maven take cares of dependency jars and plugins.<br/>
    - Allows easy acessing methods to validate JSON Response.<br/> 
    - Provides parallel run option.<br/>
    - Provides access to produce user defined Test Reports.<br/>
    - Update assertion values from properties files thus redusing change rquired to alter the code.<br/>
    
  
## PreRequisite
  Java 8
  
## Run-Command
  1. To run the Test on Non-Prod
      mvn clean install -Denv=nonProd -Dsuite=PopcornAPI -DthreadCount=4  
  2.  To run the test on Pre-Prod
      mvn clean install -Denv=PreProd -Dsuite=PopcornAPI -DthreadCount=4
      
      
