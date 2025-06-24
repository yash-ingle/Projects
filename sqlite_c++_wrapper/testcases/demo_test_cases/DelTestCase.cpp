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
string sql="DELETE FROM Employee WHERE NAME='Yash Kumar Ingle';";
sqliteDB.executeInsert(sql);
sqliteDB.close();
cout<<"Successfully deleted"<<endl;
}catch(SQLiteException &sqliteException)
{
cout<<"SQLite Error: "<<sqliteException.what()<<endl;
}
return 0;
}
