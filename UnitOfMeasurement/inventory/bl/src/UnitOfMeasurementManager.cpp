#include<bl/iuom>
#include<bl/uom>
#include<bl/iuommanager>
#include<bl/uommanager>
#include<common/stringutils>
#include<dl/iuom>
#include<dl/uom>
#include<dl/daoexception>
#include<dl/iuomdao>
#include<dl/uomdao>
#include<map>
#include<forward_list>
using namespace std;
using namespace inventory;
using namespace business_layer;
using namespace stringutils;
bool UnitOfMeasurementTitleComparator::operator()(string *left,string *right)
{
return compareStringIgnoreCase(left->c_str(),right->c_str())<0;
}
UnitOfMeasurementManager::DataModel UnitOfMeasurementManager::dataModel;
UnitOfMeasurementManager::DataModel::DataModel()
{
populateDataStructure();
}
UnitOfMeasurementManager::DataModel::~DataModel()
{
}
void UnitOfMeasurementManager::DataModel::populateDataStructure()
{
cout<<"populatedDataStructure method is invoked"<<endl;
forward_list<inventory::data_layer::abc::IUnitOfMeasurement *> *dlUnitOfMeasurements;
inventory::data_layer::UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
cout<<"Try block start"<<endl;
dlUnitOfMeasurements=unitOfMeasurementDAO.getAll();
_UnitOfMeasurement *blUnitOfMeasurement;
inventory::data_layer::abc::IUnitOfMeasurement *dlUnitOfMeasurement;
forward_list<inventory::data_layer::abc::IUnitOfMeasurement *>::iterator i;
int code;
string *title;
for(i=dlUnitOfMeasurements->begin();i!=dlUnitOfMeasurements->end();++i)
{
dlUnitOfMeasurement=*i;
code=dlUnitOfMeasurement->getCode();
title=new string(dlUnitOfMeasurement->getTitle());
blUnitOfMeasurement=new _UnitOfMeasurement;
blUnitOfMeasurement->code=code;
blUnitOfMeasurement->title=title;
dataModel.codeWiseMap.insert(pair<int,_UnitOfMeasurement *>(code,blUnitOfMeasurement));
dataModel.titleWiseMap.insert(pair<string *,_UnitOfMeasurement *>(title,blUnitOfMeasurement));
delete dlUnitOfMeasurement;
}
dlUnitOfMeasurements->clear();
delete dlUnitOfMeasurements;
cout<<"Try block end"<<endl;
}catch(inventory::data_layer::DAOException &daoException)
{
cout<<"Exception occurred"<<endl;
cout<<daoException.what()<<endl;
//no need to do anything
}
cout<<"populatedDataStructure method is ended"<<endl;
}
UnitOfMeasurementManager::UnitOfMeasurementManager()
{
}
void UnitOfMeasurementManager::addUnitOfMeasurement(abc::IUnitOfMeasurement *unitOfMeasurement) throw(BLException)
{
BLException blException;
if(unitOfMeasurement==NULL)
{
blException.setGenericException("Unit of measurement required, NULL encountered");
throw blException;
}
int code=unitOfMeasurement->getCode();
string title=unitOfMeasurement->getTitle();
if(code!=0)
{
blException.addPropertyException("code","Code should be zero");
}
if(title.length()==0)
{
blException.addPropertyException("title","Title required");
}
if(title.length()>50)
{
blException.addPropertyException("title","Length of title should not be more than 50 characters");
}
if(blException.hasExceptions())
{
throw blException;
}
map<string *,_UnitOfMeasurement *,UnitOfMeasurementTitleComparator>::iterator i;
i=dataModel.titleWiseMap.find(&title);
if(i!=dataModel.titleWiseMap.end())
{
blException.addPropertyException("title","Given title exists");
throw blException;
}
inventory::data_layer::UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
inventory::data_layer::abc::IUnitOfMeasurement *dlUnitOfMeasurement;
dlUnitOfMeasurement=new inventory::data_layer::UnitOfMeasurement;
dlUnitOfMeasurement->setCode(0);
dlUnitOfMeasurement->setTitle(title);
unitOfMeasurementDAO.add(dlUnitOfMeasurement);
unitOfMeasurement->setCode(dlUnitOfMeasurement->getCode());
code=dlUnitOfMeasurement->getCode();
delete dlUnitOfMeasurement;
string *t=new string(title);
_UnitOfMeasurement *blUnitOfMeasurement;
blUnitOfMeasurement=new _UnitOfMeasurement;
blUnitOfMeasurement->code=code;
blUnitOfMeasurement->title=t;
dataModel.codeWiseMap.insert(pair<int,_UnitOfMeasurement *>(code,blUnitOfMeasurement));
dataModel.titleWiseMap.insert(pair<string *,_UnitOfMeasurement *>(t,blUnitOfMeasurement));
}catch(inventory::data_layer::DAOException daoException)
{
BLException blException;
blException.setGenericException(string(daoException.what()));
throw blException;
}
}
void UnitOfMeasurementManager::updateUnitOfMeasurement(abc::IUnitOfMeasurement *unitOfMeasurement) throw(BLException)
{
}
void UnitOfMeasurementManager::removeUnitOfMeasurementByCode(int code) throw(BLException)
{
}
void UnitOfMeasurementManager::removeUnitOfMeasurementByTitle(string &title) throw(BLException)
{
}
abc::IUnitOfMeasurement * UnitOfMeasurementManager::getUnitOfMeasurementByCode(int code) throw(BLException)
{
return NULL;
}
abc::IUnitOfMeasurement * UnitOfMeasurementManager::getUnitOfMeasurementByTitle(string &title) throw(BLException)
{
return NULL;
}
forward_list<abc::IUnitOfMeasurement *> * UnitOfMeasurementManager::getUnitOfMeasurements() throw(BLException)
{
map<string *,_UnitOfMeasurement *,UnitOfMeasurementTitleComparator>::iterator i=dataModel.titleWiseMap.begin();
_UnitOfMeasurement *unitOfMeasurement;
abc::IUnitOfMeasurement *blUnitOfMeasurement;
forward_list<abc::IUnitOfMeasurement *> *unitOfMeasurements;
unitOfMeasurements=new forward_list<abc::IUnitOfMeasurement *>;
forward_list<abc::IUnitOfMeasurement *>::iterator listi=unitOfMeasurements->before_begin();

while(i!=dataModel.titleWiseMap.end())
{
unitOfMeasurement=i->second;
blUnitOfMeasurement=new UnitOfMeasurement;
blUnitOfMeasurement->setCode(unitOfMeasurement->code);
blUnitOfMeasurement->setTitle(*(unitOfMeasurement->title));
listi=unitOfMeasurements->insert_after(listi,blUnitOfMeasurement);
++i;
}
return unitOfMeasurements;
}
int UnitOfMeasurementManager::unitOfMeasurementCodeExists(int code) throw(BLException)
{
return 0;
}
int UnitOfMeasurementManager::unitOfMeasurementTitleExists(string &title) throw(BLException)
{
return 0;
}
int UnitOfMeasurementManager::getUnitOfMeasurementCount() throw(BLException)
{
return 0;
}

