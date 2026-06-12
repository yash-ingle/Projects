import com.thinking.machines.hr.dl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.enums.*;
import java.text.*;
import java.math.*;
import java.util.*;
public class EmployeeAddTestCase
{
public static void main(String gg[])
{
String name=gg[0];
int designationCode=Integer.parseInt(gg[1]);
SimpleDateFormat simpleDateFormat=new SimpleDateFormat("dd/MM/yyyy");
Date dateOfBirth=new Date();
try
{
dateOfBirth=simpleDateFormat.parse(gg[2]);
}catch(ParseException parseException)
{
System.out.println(parseException.getMessage());
}
char gender=gg[3].charAt(0);
boolean isIndian=Boolean.parseBoolean(gg[4]);
BigDecimal basicSalary=new BigDecimal(gg[5]);
String panNumber=gg[6];
String aadharCardNumber=gg[7];
try
{
EmployeeDTOInterface employeeDTO;
employeeDTO=new EmployeeDTO();
employeeDTO.setName(name);
employeeDTO.setDesignationCode(designationCode);
employeeDTO.setDateOfBirth(dateOfBirth);
employeeDTO.setGender((gender=='M')?GENDER.MALE:GENDER.FEMALE);
employeeDTO.setIsIndian(isIndian);
employeeDTO.setBasicSalary(basicSalary);
employeeDTO.setPANNumber(panNumber);
employeeDTO.setAadharCardNumber(aadharCardNumber);
EmployeeDAOInterface employeeDAO;
employeeDAO=new EmployeeDAO();
employeeDAO.add(employeeDTO);
System.out.println("Employee added with employeeId : "+employeeDTO.getEmployeeId());
}catch(DAOException daoException)
{
System.out.println(daoException.getMessage());
}
}
}