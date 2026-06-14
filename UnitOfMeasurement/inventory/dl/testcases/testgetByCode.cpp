#include<iostream>
#include<dl/uomdao>
#include<dl/iuom>
#include<dl/uom>
using namespace inventory;
using namespace data_layer;
int main()
{
int code;
cout<<"Enter code : ";
cin>>code;
UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
abc::IUnitOfMeasurement *unitOfMeasurement;
unitOfMeasurement=unitOfMeasurementDAO.getByCode(code);
cout<<"Code : "<<unitOfMeasurement->getCode()<<",Title : "<<unitOfMeasurement->getTitle()<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
