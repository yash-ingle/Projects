#include<iostream>
#include<dl/uomdao>
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
unitOfMeasurementDAO.remove(code);
cout<<"Unit of measurement deleted"<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
