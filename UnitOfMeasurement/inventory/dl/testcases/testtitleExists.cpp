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
if(unitOfMeasurementDAO.titleExists(title)) cout<<"Title : "<<title<<endl;
else cout<<title<<" does not exist"<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
