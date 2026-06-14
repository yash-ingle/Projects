#include<iostream>
#include<dl/uomdao>
#include<dl/uom>
using namespace inventory;
using namespace data_layer;
int main()
{
int code;
string title;
cout<<"Enter code : ";
cin>>code;
cout<<"Enter title : ";
cin>>title;
UnitOfMeasurement m;
m.setCode(code);
m.setTitle(title);
UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
unitOfMeasurementDAO.update(&m);
cout<<"Unit of measurement updated"<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
