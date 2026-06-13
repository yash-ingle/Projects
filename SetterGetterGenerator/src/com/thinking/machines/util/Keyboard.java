package com.thinking.machines.util;
import java.io.*;
public class Keyboard
{
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

// Methods For Int
public int getInt()
{
try
{
int x;
x=Integer.parseInt(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public int getInt(String str)
{
try
{
System.out.print(str);
int x;
x=Integer.parseInt(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}


// Methods For Byte
public byte getByte()
{
try
{
byte x;
x=Byte.parseByte(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public byte getByte(String str)
{
try
{
System.out.print(str);
byte x;
x=Byte.parseByte(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}


// Methods For Long
public long getLong()
{
try
{
long x;
x=Long.parseLong(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public long getLong(String str)
{
try
{
System.out.print(str);
long x;
x=Long.parseLong(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

// Methods For Short
public short getShort()
{
try
{
short x;
x=Short.parseShort(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public short getShort(String str)
{
try
{
System.out.print(str);
short x;
x=Short.parseShort(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

// Methods For Float
public float getFloat()
{
try
{
float x;
x=Float.parseFloat(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public float getFloat(String str)
{
try
{
System.out.print(str);
float x;
x=Float.parseFloat(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

// Methods For Double
public double getDouble()
{
try
{
double x;
x=Double.parseDouble(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}

public double getDouble(String str)
{
try
{
System.out.print(str);
double x;
x=Double.parseDouble(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return -1;
}
catch(NumberFormatException numberFormatException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+numberFormatException.getMessage());
return -1;
}
}


// Methods For String
public String getString()
{
try
{
String x;
x=br.readLine();
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return " ";
}
}

public String getString(String str)
{
try
{
System.out.print(str);
String x;
x=br.readLine();
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return " ";
}
}

// Methods For Char
public char getCharacter()
{
try
{
char x;
x=(char)br.read();
while(br.ready()) br.read();
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return ' ';
}
}

public char getCharacter(String str)
{
try
{
System.out.print(str);
char x;
x=(char)br.read();
while(br.ready()) br.read();
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return ' ';
}
}

// Methods For Boolean
public boolean getBoolean()
{
try
{
boolean x;
x=Boolean.parseBoolean(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return false;
}
}

public boolean getBoolean(String str)
{
try
{
System.out.print(str);
boolean x;
x=Boolean.parseBoolean(br.readLine());
return x;
}catch(IOException ioException)
{
System.out.println("Invalid input");
System.out.println("Reason : "+ioException.getMessage());
return false;
}
}
}