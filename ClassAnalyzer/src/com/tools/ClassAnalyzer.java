package com.tools;
import java.lang.reflect.*;
class ClassAnalyzer
{
public static void main(String gg[])
{
if(gg.length!=1)
{
System.out.println("Usage : java ClassAnalyzer [class_name]");
return;
}
try
{
String classToAnalyze=gg[0];
Class c=Class.forName(classToAnalyze);
System.out.println("Name (Package name included) : "+c.getName());
System.out.println("Simple Name : "+c.getSimpleName()+"\n");
Method methods[];
methods=c.getDeclaredMethods(); 
/*
getMethod() will include all methods (including base class methods)
*/
System.out.println("Number of Methods : "+methods.length);
Method method;
String methodName;
Class methodReturnType;
Class parameters[];
int e=0;
int j=0;
for(e=0;e<methods.length;e++)
{
method=methods[e];
methodName=method.getName();
System.out.println("Name of Method : "+methodName);
methodReturnType=method.getReturnType();
System.out.println("Return Type : "+methodReturnType.getName());
parameters=method.getParameterTypes();
System.out.println("Number of parameters : "+parameters.length);
for(j=0;j<parameters.length;j++)
{
System.out.printf("Parameter number %d, Type : %s\n",j+1,parameters[j].getName());
}
System.out.println("******************************************************");
}
Field fields[];
fields=c.getDeclaredFields();
System.out.println("\nNumber of fields(property) : "+fields.length);
Field field;
String fieldName;
Class fieldType;
for(e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();
System.out.printf("Field(property) Number %d, Name : %s, Type : %s\n",e+1,fieldName,fieldType);
}
}catch(ClassNotFoundException classNotFoundException)
{
System.out.println("Class : "+classNotFoundException.getMessage()+" not found");
}
}
}