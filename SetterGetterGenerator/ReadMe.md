# How to Use
## Prerequisites
Before running the application, ensure the following is installed and configured:
- Java 8 or later version
- JAVA_HOME environment variable configured (recommended)

---
## SetterGetterGenerator
- Open Command Prompt.
- Go to the ```testcases\SetterGetterGeneratorTestCase``` folder.
- Create the class for which you want to generate setter(s) and getter(s) [or default constructor] (Example: Student class).\
File Name: **Student.java**
```
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
- Run the following commands to generate the setter(s) and getter(s) [or default constructor].

<img src="https://github.com/yash-ingle/Projects/blob/main/SetterGetterGenerator/screenshots/SetterGetterGenerator_1.PNG">

- Setter(s) and getter(s) [or default constructor] for Student class is generated in file ```generated_data.tmp```.

<img src="https://github.com/yash-ingle/Projects/blob/main/SetterGetterGenerator/screenshots/SetterGetterGenerator_2.PNG">

> **Note:** Do not forget to include the jar file (```..\..\testcases\SetterGetterGenerator.jar```) in the classpath.

---
