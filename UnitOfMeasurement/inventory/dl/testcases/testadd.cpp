#include<iostream>
#include<dl/uomdao>
#include<dl/uom>
using namespace std;
using namespace inventory;
using namespace data_layer;
int main()
{
string title;
cout<<"Enter title : ";
cin>>title;
UnitOfMeasurement m;
m.setTitle(title);
UnitOfMeasurementDAO unitOfMeasurementDAO;
try
{
unitOfMeasurementDAO.add(&m);
cout<<"Unit of measurement added with code as : "<<m.getCode();
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
