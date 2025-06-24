#include<sqlite_wrapper>
#include<sqlite_exception>
#include<string.h>
#include<map>
#include<iostream>
using namespace sqlite;
/*
Implementation of class Row Functionalities. (starts here)
*/
// Special Functions (class Row)
Row & Row::operator=(const Row &other)
{
this->rowData=other.rowData;
//print("operator=");
return *this;
}

//Constructors (class Row)
Row::Row()
{
}
Row::Row(map<string,string> &rowData)
{
this->rowData=rowData;
}
Row::Row(const Row &other)
{
this->rowData=other.rowData;
//print("Copy Constructor");
}

// Member Funtions (class Row)
int Row::getInt(string columnName)
{
map<string,string>::iterator it;
it=this->rowData.find(columnName);
if(it==this->rowData.end()) return 0;
return atoi(it->second.c_str());
}
string Row::getString(string columnName)
{
map<string,string>::iterator it;
it=this->rowData.find(columnName);
if(it==this->rowData.end()) return "";
return it->second;
}

// Helper Functions (class Row)
void Row::print(string str)
{
cout<<"***********"<<endl;
cout<<str<<" is called from class Row"<<endl;
cout<<"ROW DATA : "<<&this->rowData<<endl;
map<string,string>::iterator it=this->rowData.begin();
for(;it!=this->rowData.end();++it) cout<<it->first<<" : "<<it->second<<endl;
cout<<"ROW DATA SIZE : "<<this->rowData.size()<<endl;
cout<<"***********"<<endl;
}

// Destructor (class Row)
Row::~Row()
{
this->rowData.clear();
//print("Destructor");
}
/*
Implementation of class Row Functionalities. (ends here)
*/



/*
Implementation of class Rows Functionalities. (starts here)
*/
// Constructors (class Rows)
Rows::Rows()
{
this->sql="";
this->FILE_NAME="";
this->db=nullptr;
rowFetched=0;
rowCount=0;
currentRow=0;
rowCountIt=0;
//print("Default Constructor");
}
Rows::Rows(string sql,sqlite3 *db,string fileName)
{
this->sql=sql;
this->FILE_NAME=fileName;
this->db=db;
rowFetched=0;
rowCount=0;
currentRow=0;
rowCountIt=0;
//print("Parameteric Constructor");
}
Rows::Rows(const Rows &other)
{
this->sql=other.sql;
this->FILE_NAME=other.FILE_NAME;
this->db=other.db;  
this->rowData=other.rowData;
this->rowFetched=other.rowFetched;
this->rowCount=other.rowCount;
this->currentRow=other.currentRow;
this->rowCountIt=other.rowCountIt;
//print("Copy Constructor");
}

// Member Functions (class Rows)
int Rows::hasMoreRows()
{
if(rowCount>0) rowCount=0; 
char *errorMessage=nullptr;
int result=sqlite3_exec(this->db,this->sql.c_str(),getRowCount,&rowCount,&errorMessage);
if(result!=SQLITE_OK)
{
string message=errorMessage;
sqlite3_free(errorMessage);
sqlite3_close(this->db);
this->db=nullptr;
throw SQLiteException(message.c_str());
}
//print("hasMoreRow");
if(currentRow<rowCount) return 1;
return 0;
}

Row Rows::getRow()
{
if(rowFetched==1) this->rowData.clear();
rowCountIt=0;
char *errorMessage=nullptr;
int result=sqlite3_exec(this->db,this->sql.c_str(),getRowData,(this),&errorMessage);
rowFetched=1;
//print("getRow");
currentRow++;
return Row(rowData);
}

//helper Functions (class Rows)
int Rows::getRowCount(void *ptr,int columnCount,char **dataPtr,char **columnNamePtr)
{
int *rowCount=(int *)ptr;
(*rowCount)++;
return 0;
}

int Rows::getRowData(void *ptr,int columnCount,char **dataPtr,char **columnNamePtr)
{
Rows *rowsObj=(Rows *)ptr;
if(rowsObj->rowCountIt==rowsObj->currentRow)
{
for(int i=0;i<columnCount;i++)
{
if(dataPtr[i]) rowsObj->rowData[columnNamePtr[i]]=dataPtr[i];
else rowsObj->rowData[columnNamePtr[i]]="";
}
return 1;
}
rowsObj->rowCountIt++;
return 0;
}

void Rows::print(string str)
{
cout<<"***********"<<endl;
cout<<str<<" is called from Rows"<<endl;
cout<<"DB : "<<this->db<<endl;
cout<<"FILE_NAME : "<<this->FILE_NAME<<endl;
cout<<"SQL : "<<this->sql<<endl;
cout<<"ROW DATA : "<<&this->rowData<<endl;
map<string,string>::iterator it=this->rowData.begin();
for(;it!=this->rowData.end();++it) cout<<it->first<<" : "<<it->second<<endl;
cout<<"ROW DATA SIZE : "<<this->rowData.size()<<endl;
cout<<"ROW FETCHED : "<<this->rowFetched<<endl;
cout<<"ROW COUNT : "<<this->rowCount<<endl;
cout<<"CURRENT ROW : "<<this->currentRow<<endl;
cout<<"ROW COUNT IT : "<<rowCountIt<<endl;
cout<<"***********"<<endl;
}

//Destructor (class Rows)
Rows::~Rows()
{
this->sql="";
this->FILE_NAME="";
this->db=nullptr;
rowFetched=0;
rowCount=0;
currentRow=0;
rowCountIt=0;
this->rowData.clear();
//print("Destructor");
}
/*
Implementation of class Rows Functionalities. (ends here)
*/



/*
Implementation of class SqliteDB Functionalities. (starts here)
*/
// Special Member Functions (class SqliteDB)

Rows SqliteDB::selectRows(string &sql)
{
Rows rows(sql,this->db,this->FILE_NAME);
return rows;
}

// Constructors (class SqliteDB)
SqliteDB::SqliteDB()
{
this->db=nullptr;
this->result=0;
this->errorMessage=nullptr;
this->FILE_NAME="";
}

SqliteDB::SqliteDB(string fileName)
{
this->FILE_NAME=fileName;
if(this->FILE_NAME=="") throw SQLiteException("File name is empty, unable to open");
this->result=sqlite3_open(this->FILE_NAME.c_str(),&this->db);
this->errorMessage=nullptr;
if(this->result!=SQLITE_OK)
{
throw SQLiteException(sqlite3_errmsg(db));
}
}

// Member Functions (class SqliteDB)
void SqliteDB::open(string fileName)
{
this->FILE_NAME=fileName;
if(this->FILE_NAME=="") throw SQLiteException("File name is empty, unable to open");
this->result=sqlite3_open(FILE_NAME.c_str(),&this->db);
if(this->result!=SQLITE_OK)
{
throw SQLiteException(sqlite3_errmsg(db));
}
}

void SqliteDB::executeCreateTable(string &sql)
{
if(this->FILE_NAME=="") throw SQLiteException("File name is empty");
this->result=sqlite3_exec(this->db,sql.c_str(),0,0,&this->errorMessage);
if(this->result!=SQLITE_OK)
{
throw SQLiteException(this->errorMessage);
}
}

void SqliteDB::executeInsert(string &sql)
{
if(this->FILE_NAME=="") throw SQLiteException("File name is empty");
this->result=sqlite3_exec(this->db,sql.c_str(),0,0,&this->errorMessage);
if(this->result!=SQLITE_OK)
{
throw SQLiteException(this->errorMessage);
}
}

void SqliteDB::executeUpdate(string &sql)
{
if(this->FILE_NAME=="") throw SQLiteException("File name is empty");
this->result=sqlite3_exec(this->db,sql.c_str(),0,0,&this->errorMessage);
if(this->result!=SQLITE_OK)
{
throw SQLiteException(this->errorMessage);
}
}

void SqliteDB::executeDelete(string &sql)
{
if(this->FILE_NAME=="") throw SQLiteException("File name is empty");
this->result=sqlite3_exec(this->db,sql.c_str(),0,0,&this->errorMessage);
if(this->result!=SQLITE_OK)
{
throw SQLiteException(this->errorMessage);
}
}

void SqliteDB::close()
{
if(this->db != nullptr) 
{
sqlite3_close(this->db);
this->db = nullptr;
}
if(this->errorMessage) sqlite3_free(this->errorMessage);
}

// Destructor (class SqliteDB)
SqliteDB::~SqliteDB()
{
this->close();
}
/*
Implementation of class SqliteDB Functionalities. (ends here)
*/
