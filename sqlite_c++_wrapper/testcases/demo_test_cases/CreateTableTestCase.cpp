#include<sqlite_wrapper>
#include<sqlite_exception>
#include<iostream>
using namespace std;
using namespace sqlite;
int main()
{
try
{
SqliteDB sqliteDB("../../db/employee_data.db");
string sql="create table Employee(EMPLOYEE_ID int primary key,NAME char(21),GENDER char(1),SALARY int,DEPARTMENT char(21));";
sqliteDB.executeCreateTable(sql);
sqliteDB.close();
cout<<"Table is successfully created"<<endl;
}catch(SQLiteException &sqliteException)
{
cout<<"SQLite Error: "<<sqliteException.what()<<endl;
}
return 0;
}
