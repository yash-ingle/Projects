import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;
class EmployeeManagerGetEmployeeByAadharCardNumberTestCase
{
public static void main(String gg[])
{
String aadharCardNumber="U12345678";
try
{
EmployeeManagerInterface employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee=new Employee();
employee=employeeManager.getEmployeeByAadharCardNumber(aadharCardNumber);
System.out.println("Employee Id. : "+employee.getEmployeeId());
System.out.println("Name : "+employee.getName());
System.out.println("Designation Code : "+employee.getDesignation().getCode()+", Designation Title :"+employee.getDesignation().getTitle());
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
System.out.println("Date of birth : "+simpleDateFormat.format(employee.getDateOfBirth()));
System.out.println("Gender : "+employee.getGender());
System.out.println("Is indian : "+employee.getIsIndian());
System.out.println("Basic salary : "+employee.getBasicSalary());
System.out.println("PAN number : "+employee.getPANNumber());
System.out.println("Aadhar card number : "+employee.getAadharCardNumber());
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