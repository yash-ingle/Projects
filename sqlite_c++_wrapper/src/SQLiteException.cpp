#include<sqlite_exception>
#include<string>
#include<iostream>
using namespace std;
using namespace sqlite;
SQLiteException::SQLiteException()
{
this->message="";
}
SQLiteException::SQLiteException(const char *message)
{
this->message=message;
}
SQLiteException::~SQLiteException() throw()
{
}
const char * SQLiteException::what() const throw()
{
return this->message.c_str();
}

