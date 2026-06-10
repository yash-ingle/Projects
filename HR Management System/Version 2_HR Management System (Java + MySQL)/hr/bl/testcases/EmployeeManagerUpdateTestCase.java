import com.thinking.machines.hr.bl.managers.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.enums.*;
import java.util.*;
import java.text.*;
import java.math.*;
class EmployeeManagerUpdateTestCase
{
public static void main(String gg[])
{
String employeeId="A10000001";
String name="Yash";
DesignationInterface designation=new Designation();
designation.setCode(1);
Date dateOfBirth=new Date("4/2/2003");
boolean isIndian=false;
BigDecimal basicSalary=new BigDecimal("900000");
String panNumber="A123450";
String aadharCardNumber="U123450";
try
{
EmployeeManagerInterface employeeManager=EmployeeManager.getEmployeeManager();
EmployeeInterface employee=new Employee();
employee.setEmployeeId(employeeId);
employee.setName(name);
employee.setDesignation(designation);
employee.setDateOfBirth(dateOfBirth);
employee.setGender(GENDER.MALE);
employee.setIsIndian(isIndian);
employee.setBasicSalary(basicSalary);
employee.setPANNumber(panNumber);
employee.setAadharCardNumber(aadharCardNumber);
employeeManager.updateEmployee(employee);
System.out.println("Employee Updated");
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