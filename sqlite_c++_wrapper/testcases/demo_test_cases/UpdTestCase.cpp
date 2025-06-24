#include<sqlite_wrapper>
#include<sqlite_exception>
#include<iostream>
using namespace std;
using namespace sqlite;
int main()
{
try
{
SqliteDB sqliteDB;
sqliteDB.open("../../db/employee_data.db");
string sql="UPDATE Employee SET SALARY='3600000' WHERE NAME='Yash Kumar Ingle';";
sqliteDB.executeUpdate(sql);
cout<<"Successfully updated"<<endl;
sqliteDB.close();
}catch(SQLiteException &sqliteException)
{
cout<<"SQLite Error: "<<sqliteException.what()<<endl;
}
return 0;
}
