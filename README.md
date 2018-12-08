# Retail Store Discount Calculator
======================================
-----
Build:
```bash
mvn clean install
```
Testing
-------
Run unit test:
```bash
mvn test
```
Generate test coverage report
```bash
mvn test
```
To see the output go to target directory and open index.html from jacoco-ut folder in browser.

#### Running Application
This can be done using a full Maven `install` lifecycle:
Steps:
```bash
maven install
```
```bash
Go to "target" folder
Copy below two files to "target" folder
  1. runner.cmd
  2. Bill.json
Open command Prompt window in "target" folder.
Now make the changes in "Bill.json" accordingly
Run "runner.cmd"
See the output on console.
```
#### Prerequisite
Java and Maven should be installed on system.
Do not change the "Bill.json" file structure and name.
