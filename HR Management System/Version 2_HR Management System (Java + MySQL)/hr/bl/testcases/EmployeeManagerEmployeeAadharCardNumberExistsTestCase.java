import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;
class EmployeeManagerEmployeeAadharCardNumberExistsTestCase
{
public static void main(String gg[])
{
String aadharCardNumber="U1234567";
try
{
EmployeeManagerInterface employeeManager=EmployeeManager.getEmployeeManager();
boolean aadharCardNumberFound=employeeManager.employeeAadharCardNumberExists(aadharCardNumber);
System.out.println("Aadhar card number "+aadharCardNumber+" exists : "+aadharCardNumberFound);
}catch(BLException blException)
{
if(blException.hasGenericException())
{
System.out.println(blException.getGenericException());
}
List<String> properties=blException.getProperties();
for(String property: properties)
{
System.out.println(blException.getException(property));
}
}
}
}