# How to Use
## Prerequisites
Before running the application, ensure the following is installed and configured:
- Java 8 or later version
- JAVA_HOME environment variable configured (recommended)

---
## SetterGetterGenerator
- Open Command Prompt.
- Go to the ```testcases\SetterGetterGeneratorTestCase``` folder.
- Create the class for which you want to generate setter(s), and getter(s), [or a default constructor] (Example: Student class).

File Name: **Student.java**
```java
import java.util.*;
class Student
{
int rollNumber;
String name;
int age;
Date dateOfBirth;
}
```

- Run ```javac Student.java``` to generate the **Student.class** file.
- Run the following commands to generate the setter(s), and getter(s), [or a default constructor].

<img src="https://github.com/yash-ingle/Projects/blob/main/SetterGetterGenerator/screenshots/SetterGetterGenerator_1.PNG">

- Setter(s), and getter(s), [or a default constructor] for Student class is generated in file ```generated_data.tmp```.

<img src="https://github.com/yash-ingle/Projects/blob/main/SetterGetterGenerator/screenshots/SetterGetterGenerator_2.png">

-Now copy and paste the generated content into the Student class."

> **Note:** Do not forget to include the jar file (```..\..\dist\SetterGetterGenerator.jar```) in the classpath.

---

## Usage of This Tool

Every class in a project may require setter(s), and getter(s), [or a default constructor]. If a class contains hundreds of properties, writing these setter(s), getter(s), [or default constructor] manually can be a time-consuming and repetitive task.

The **SetterGetterGenerator** tool automates this process by generating the required setter(s), and getter(s), [or a default constructor] within a few seconds. This helps developers save time, reduce manual effort, and focus on the core functionality and business logic of the project.

