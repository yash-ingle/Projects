#include<sqlite_wrapper>
#include<sqlite_exception>
#include<string>
#include<iostream>
using namespace std;
using namespace sqlite;
int main()
{
SqliteDB sqliteDB;
try
{
sqliteDB.open("../../db/employee_data.db");
string sql="select * from Employee;";
Rows rows;
rows=sqliteDB.selectRows(sql);
Row row;
int rollnumber;
string name;
int x=0;
while(rows.hasMoreRows())
{
if(x==0) x=1; 
cout<<"Employee Details"<<endl;
row=rows.getRow();
int id=row.getInt("EMPLOYEE_ID");
cout<<"ID : "<<id<<endl;
string name=row.getString("NAME");
cout<<"Name : "<<name<<endl;
string gender=row.getString("GENDER");
cout<<"Gender : "<<gender<<endl;
int salary=row.getInt("SALARY");
cout<<"Salary : "<<salary<<endl;
string dept=row.getString("DEPARTMENT");
cout<<"Department : "<<dept<<endl;
cout<<"*********************************"<<endl;
}
if(x==0) cout<<"No Data Found"<<endl;
}catch(SQLiteException &sqliteException)
{
cout<<"SQLite Error: "<<sqliteException.what()<<endl;
}
return 0;
}
