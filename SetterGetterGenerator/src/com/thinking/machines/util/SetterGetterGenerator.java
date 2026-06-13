package com.thinking.machines.util;
import java.lang.reflect.*;
import java.io.*;
public class SetterGetterGenerator
{
private static String DATA_FILE="generated_data.tmp";
public static void main(String gg[])
{
if(gg.length!=1 && gg.length!=2)
{
System.out.println("Usage : java -classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name [constructor=true/false]");
return;
}
if(gg.length==2)
{
if(gg[1].equalsIgnoreCase("constructor=true")==false && gg[1].equalsIgnoreCase("constructor=false")==false)
{
System.out.println("Usage : java -classpath path_to_jar_file;. com.thinking.machines.util.SetterGetterGenerator class_name [constructor=true/false]");
return;
}
}
try
{
String className=gg[0];
Class c=Class.forName(className);
Field fields[];
fields=c.getDeclaredFields();
Field field;
Class fieldType;
String fieldName;
String fieldTypeName;
String setterName;
String getterName;
String line;
TMList<String> list=new TMArrayList<String>();
if(gg.length==1 || (gg.length==2 && gg[1].equalsIgnoreCase("constructor=true")))
{
line="public "+c.getSimpleName()+"()";
list.add(line);
list.add("{");
for(int e=0;e<fields.length;e++)
{
field=fields[e];
line="this."+field.getName()+"="+getDefaultValue(field.getType())+";";
list.add(line);
}
list.add("}");
}
for(int i=0;i<fields.length;i++)
{
field=fields[i];
fieldName=field.getName();
fieldType=field.getType();
fieldTypeName=fieldType.getName();
if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122)
{
setterName="set"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
getterName="get"+fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
}
else
{
setterName="set"+fieldName;
getterName="get"+fieldName;
}
line="public void "+setterName+"("+fieldTypeName+" "+fieldName+")";
list.add(line);
list.add("{");
line="this."+fieldName+"="+fieldName+";";
list.add(line);
list.add("}");
line="public "+fieldTypeName+" "+getterName+"()";
list.add(line);
list.add("{");
line="return this."+fieldName+";";
list.add(line);
list.add("}");
}
File file=new File(DATA_FILE);
if(file.exists()) file.delete();
RandomAccessFile randomAccessFile=new RandomAccessFile(file,"rw");
list.forEach((str)->{
try
{
randomAccessFile.writeBytes(str+"\r\n");
}catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
});
randomAccessFile.close();
System.out.println("setter/getter for "+c.getSimpleName()+" class is generated in file "+DATA_FILE);
}catch(ClassNotFoundException cnfe)
{
System.out.println(cnfe.getMessage()+" class not found.");
}
catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}
private static String getDefaultValue(Class c)
{
String className=c.getName();
if(className.equals("java.lang.Long") || className.equals("long")) return "0";
if(className.equals("java.lang.Byte") || className.equals("byte")) return "0";
if(className.equals("java.lang.Short") || className.equals("short")) return "0";
if(className.equals("java.lang.Integer") || className.equals("int")) return "0";
if(className.equals("java.lang.Double") || className.equals("double")) return "0.0";
if(className.equals("java.lang.Float") || className.equals("float")) return "0.0f";
if(className.equals("java.lang.Character") || className.equals("char")) return "' '";
if(className.equals("java.lang.Boolean") || className.equals("boolean")) return "false";
if(className.equals("java.lang.String")) return "\"\"";
return "null";
}
}