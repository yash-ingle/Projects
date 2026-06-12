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

> **Note:** Java, Gradle, and MySQL environment variables must be configured correctly on the host machine before running this project. Verify that the corresponding executables are accessible from the command line.

---
# How to Run
## Version 1\_HR Management System (Java)
### Build and Run
Version 1\_HR Management System (java)\hr\\pl>__```gradle build```__\
**SUCCESSFUL BUILD**

Version 1\_HR Management System\\hr\\pl>__```java -classpath ..\common\dist\hr-common.jar;..\dl\dist\hr-dl-1.0.jar;..\bl\build\libs\bl.jar;..\pl\build\libs\pl.jar;..\pl\libs\*;. com.thinking.machines.hr.pl.Main```__

**It opens the user interface, allowing you to use all features of the application.**

<p align="center">
    <img src="https://github.com/yash-ingle/Projects/blob/main/HR%20Management%20System/screenshots/HR_Management_System_V1.png" width="400" height="800">
</p>

---

## Version 2\_HR Management System (Java + MySQL)

### Database Setup

Open Command Prompt and execute the following commands to create the database, user, and required tables.

**Step 1: Create Database and User**

```
mysqlsh
```
```
\sql
```
```
\connect root@localhost:3306
```
```sql
create database hrdb;
```
```sql
create user 'hr'@'localhost' identified by 'hr';
```
```sql
grant all privileges on hrdb.* to 'hr'@'localhost';
```
```
\exit
```

**Step 2: Create Required Tables**

```
mysqlsh
```
```
\sql
```
```
\connect hr@localhost:3306/hrdb
```
```sql
create table designation
(
    code int primary key auto_increment,
    title char(35) not null
);
```
```sql
create table employee
(
    employee_id int primary key auto_increment,
    name char(30) not null,
    designation_code int not null,
    date_of_birth date not null,
    gender char(1) not null,
    basic_salary decimal(12,2) not null,
    is_indian boolean not null,
    pan_number char(20) not null unique,
    aadhar_card_number char(20) not null unique,
    foreign key (designation_code) references designation(code)
);
```
```
\exit
```

> **Note:** Ensure that MySQL Server is running on `localhost:3306` before executing the above commands.

### Build and Run
Version 2\_HR Management System\\hr\\dbdl>__```gradle build```__\
**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\bl>__```gradle build```__\
**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\pl>__```gradle build```__\
**SUCCESSFUL BUILD**

Version 2\_HR Management System\\hr\\pl>__```java -classpath ..\common\dist\hr-common.jar;..\dbdl\build\libs\dbdl.jar;..\dbdl\libs\*;..\bl\build\libs\bl.jar;..\pl\build\libs\pl.jar;..\pl\libs\*;. com.thinking.machines.hr.pl.Main```__

**It opens the user interface, allowing you to use all features of the application.**

<p align="center">
    <img src="https://github.com/yash-ingle/Projects/blob/main/HR%20Management%20System/screenshots/HR_Management_System_V2.png" width="400" height="800">
</p>

---
