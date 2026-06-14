#include <sqlite_wrapper>
#include <sqlite_exception>
#include <iostream>
using namespace std;
using namespace sqlite;
int main() {
try {
int e;
SqliteDB sqliteDB("../../db/employee_data.db");
cout<<"Enter the number of Employees: ";
cin>>e;
cin.ignore();
for(int i=0;i<e;i++) 
{
string name,id,gender,salary,dept;
cout<<"Enter Employee's Details"<<endl;
cout<<"Enter Employee ID : ";
getline(cin,id);
fflush(stdin);
cout<<"Enter Employee Name : ";
getline(cin,name);
fflush(stdin);
cout<<"Enter Employee Gender : ";
getline(cin,gender);
fflush(stdin);
cout<<"Enter Employee Salary : ";
getline(cin,salary);
fflush(stdin);
cout<<"Enter Employee Department : ";
getline(cin,dept);
fflush(stdin);
char tmpsql[512];
sprintf(tmpsql,"INSERT INTO Employee VALUES ('%s','%s','%s','%s','%s');",id.c_str(),name.c_str(),gender.c_str(),salary.c_str(),dept.c_str());
string sql=string(tmpsql);
sqliteDB.executeInsert(sql);
cout<<"Employee added"<<endl;
}
sqliteDB.close();
} catch (SQLiteException &sqliteException) {
cout<<"SQLite Error: "<<sqliteException.what()<<endl;
}
return 0;
}
