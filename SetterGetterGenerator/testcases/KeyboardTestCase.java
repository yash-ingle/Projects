import com.thinking.machines.util.*;
class KeyboardTestCase
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();
String name;
char gender;
int age;
double salary;
System.out.print("Name : ");
name=k.getString();
gender=k.getCharacter("Gender (M/F) : ");
age=k.getInt("Age : ");
salary=k.getDouble("Salary : ");
System.out.println("Name : "+name);
System.out.println("Age : "+age);
System.out.println("Gender : "+gender);
System.out.println("Salary : "+salary);
}
}

/*
class psp
{
public static void main(String gg[])
{
Keyboard k=new Keyboard();

int x;
System.out.print("Enter a number : ");
x=k.getInt();
System.out.println(x);

byte y;
System.out.print("Enter a number : ");
y=k.getByte();
System.out.println(y);

long u;
System.out.print("Enter a number : ");
u=k.getLong();
System.out.println(u);

short v;
System.out.print("Enter a number : ");
v=k.getShort();
System.out.println(v);

float n;
System.out.print("Enter a decimal number : ");
n=k.getFloat();
System.out.println(n);

double m;
System.out.print("Enter a decimal number : ");
m=k.getDouble();
System.out.println(m);

char c;
System.out.print("Enter a char : ");
c=k.getChar();
System.out.println(c);

String s;
System.out.print("Enter a string : ");
s=k.getString();
System.out.println(s);

Boolean b;
System.out.print("Enter a true/false : ");
b=k.getBoolean();
System.out.println(b);

int aa;
aa=k.getInt("Enter a number : ");
System.out.println(aa);

byte bb;
bb=k.getByte("Enter a number : ");
System.out.println(bb);

Short cc;
cc=k.getShort("Enter a number : ");
System.out.println(cc);

long dd;
dd=k.getLong("Enter a number : ");
System.out.println(dd);

float ee;
ee=k.getFloat("Enter a decimal number : ");
System.out.println(ee);

double ff;
ff=k.getDouble("Enter a decimal number : ");
System.out.println(ff);

String g;
g=k.getString("Enter a string : ");
System.out.println(g);

char hh;
hh=k.getChar("Enter a character: ");
System.out.println(hh);

boolean ii;
ii=k.getBoolean("Enter a True/False : ");
System.out.println(ii);
}
}
*/