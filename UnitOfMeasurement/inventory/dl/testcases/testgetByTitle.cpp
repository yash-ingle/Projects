#include<iostream>
#include<dl/uomdao>
#include<dl/iuom>
#include<dl/uom>
using namespace inventory;
using namespace data_layer;
int main()
{
string title;
cout<<"Enter title : ";
cin>>title;
UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
abc::IUnitOfMeasurement *unitOfMeasurement;
unitOfMeasurement=unitOfMeasurementDAO.getByTitle(title);
cout<<"Code : "<<unitOfMeasurement->getCode()<<",Title : "<<unitOfMeasurement->getTitle()<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
