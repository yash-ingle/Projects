#include<iostream>
#include<dl/uomdao>
#include<dl/iuom>
#include<dl/uom>
using namespace inventory;
using namespace data_layer;
int main()
{
UnitOfMeasurementDAO unitOfMeasurementDAO;
cout<<"Number of records in context to unit of measurement : "<<unitOfMeasurementDAO.getCount()<<endl;
return 0;
}
