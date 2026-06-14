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
if(unitOfMeasurementDAO.codeExists(code)) cout<<"Code : "<<code<<endl;
else cout<<code<<" does not exist"<<endl;
}catch(DAOException daoException)
{
cout<<daoException.what();
}
return 0;
}
