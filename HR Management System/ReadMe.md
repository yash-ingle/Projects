# Prerequisites
Before setting up and running this project, ensure the following software is installed on your system:
|**Software**|**Required Version**|**Purpose**|
|:-----------|:-----------------:|:---------|
|Java |25.0.2|Runtime and development platform|
|Gradle|9.0.0|Build automation and dependency management|
|MySQL|8.0.46|Database management system|

## Installation Resources

- Java: [Oracle JDK Downloads](https://www.oracle.com/java/technologies/downloads/)

- Gradle: [Gradle Installation Guide](https://docs.gradle.org/current/userguide/installation.html)

- MySQL: [MySQL Community Server Downloads](https://dev.mysql.com/downloads/mysql/)

**Note:** 
> Java, Gradle, and MySQL environment variables must be configured correctly on the host machine before running this project. Verify that the corresponding executables are accessible from the command line.

---
# How to Run
## Version 1\_HR Management System (Java)

Version 1\_HR Management System\\hr\\dl>gradle build

**SUCCESSFUL BUILD**

Version 1\_HR Management System\\hr\\bl>gradle build

**SUCCESSFUL BUILD**

Version 1\_HR Management System\\hr\\pl>gradle build

**SUCCESSFUL BUILD**

Version 1\_HR Management System\\hr\\pl>java -classpath ..\\common\\dist\\hr-common.jar;..\\dbdl\\build\\libs\\dbdl.jar;..\\bl\\build\\libs\\bl.jar;..\\pl\\build\\libs\\pl.jar;..\\pl\\libs\\\*;. com.thinking.machines.hr.pl.Main

**It opens the UI.**



## Version 2\_HR Management System (Java + MySQL)

Version 2\_HR Management System\\hr\\dbdl>gradle build

**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\bl>gradle build

**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\pl>gradle build

**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\pl>java -classpath ..\\common\\dist\\hr-common.jar;..\\dbdl\\build\\libs\\dbdl.jar;..\\dbdl\\libs\\\*;..\\bl\\build\\libs\\bl.jar;..\\pl\\build\\libs\\pl.jar;..\\pl\\libs\\\*;. com.thinking.machines.hr.pl.Main

**It opens the UI.**

