package com.thinking.machines.hr.bl.managers;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.interfaces.managers.*;
import com.thinking.machines.hr.bl.pojo.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.dl.interfaces.dto.*;
import com.thinking.machines.hr.dl.interfaces.dao.*;
import com.thinking.machines.hr.dl.dto.*;
import com.thinking.machines.hr.dl.dao.*;
import com.thinking.machines.hr.dl.exceptions.*;
import java.util.*;
public class DesignationManager implements DesignationManagerInterface
{
private Map<Integer,DesignationInterface> codeWiseDesignationsMap;
private Map<String,DesignationInterface> titleWiseDesignationsMap;
private Set<DesignationInterface> designationsSet;
private static DesignationManager designationManager=null;
private DesignationManager() throws BLException
{
populateDataStructures();
}
private void populateDataStructures() throws BLException
{
this.codeWiseDesignationsMap=new HashMap<>();
this.titleWiseDesignationsMap=new HashMap<>();
this.designationsSet=new TreeSet<>();
try
{
Set<DesignationDTOInterface> dlDesignations;
dlDesignations=new DesignationDAO().getAll();
DesignationInterface designation;
for(DesignationDTOInterface dlDesignation: dlDesignations)
{
designation=new Designation();
designation.setCode(dlDesignation.getCode());
designation.setTitle(dlDesignation.getTitle());
codeWiseDesignationsMap.put(new Integer(designation.getCode()),designation);
titleWiseDesignationsMap.put(designation.getTitle().toUpperCase(),designation);
designationsSet.add(designation);
}
}catch(DAOException daoException)
{
BLException blException=new BLException();
blException.setGenericException(daoException.getMessage());
throw blException;
}
}
public static DesignationManager getDesignationManager() throws BLException
{
if(designationManager==null) designationManager=new DesignationManager();
return designationManager;
}
public void addDesignation(DesignationInterface designation) throws BLException
{
BLException blException=new BLException();
if(designation==null)
{
blException.setGenericException("Designation required");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();
if(code!=0)
{
blException.addException("code","Code should be zero");
}
if(title==null)
{
blException.addException("title","Title required");
title="";
}
else
{
title=title.trim();
if(title.length()==0)
{
blException.addException("title","Title required");
}
}
if(title.length()>0)
{
if(this.titleWiseDesignationsMap.containsKey(title.toUpperCase()))
{
blException.addException("title","Designation : "+title+" exists.");
}
}
if(blException.hasExceptions())
{
throw blException;
}
try
{
DesignationDTOInterface designationDTO=new DesignationDTO();
designationDTO.setTitle(title);
DesignationDAOInterface designationDAO=new DesignationDAO();
designationDAO.add(designationDTO);
code=designationDTO.getCode();
designation.setCode(code);
Designation dsDesignation=new Designation();
dsDesignation.setCode(code);
dsDesignation.setTitle(title);
codeWiseDesignationsMap.put(new Integer(code),dsDesignation);
titleWiseDesignationsMap.put(title.toUpperCase(),dsDesignation);
designationsSet.add(dsDesignation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
}
}
public void updateDesignation(DesignationInterface designation) throws BLException
{
BLException blException=new BLException();
if(designation==null)
{
blException.setGenericException("Designation required");
throw blException;
}
int code=designation.getCode();
String title=designation.getTitle();
if(code<=0)
{
blException.addException("code","Invalid code : "+code);
}
if(code>0)
{
if(this.codeWiseDesignationsMap.containsKey(new Integer(code))==false)
{
blException.addException("code","Invalid code : "+code);
throw blException;
}
}
if(title==null)
{
blException.addException("title","Title required");
title="";
}
else
{
title=title.trim();
if(title.length()==0)
{
blException.addException("title","Title required");
}
}
if(title.length()>0)
{
DesignationInterface d;
d=titleWiseDesignationsMap.get(title.toUpperCase());
if(d!=null && d.getCode()!=code)
{
blException.addException("title","Designation : "+title+" exists.");
}
}
if(blException.hasExceptions())
{
throw blException;
}
try
{
DesignationInterface dsDesignation;
dsDesignation=codeWiseDesignationsMap.get(code);
DesignationDTOInterface dlDesignation=new DesignationDTO();
dlDesignation.setCode(code);
dlDesignation.setTitle(title);
new DesignationDAO().update(dlDesignation);
// remove the old one from all DS
codeWiseDesignationsMap.remove(code);
titleWiseDesignationsMap.remove(dlDesignation.getTitle().toUpperCase());
designationsSet.remove(dsDesignation);
// update the DS Object
dsDesignation.setTitle(title);
// update the DS
codeWiseDesignationsMap.put(code,dsDesignation);
titleWiseDesignationsMap.put(title.toUpperCase(),dsDesignation);
designationsSet.add(dsDesignation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
}
}
public void removeDesignation(int code) throws BLException
{
BLException blException=new BLException();
if(code<=0)
{
blException.addException("code","Invalid code : "+code);
}
if(code>0)
{
if(this.codeWiseDesignationsMap.containsKey(new Integer(code))==false)
{
blException.addException("code","Invalid code : "+code);
throw blException;
}
}if(blException.hasExceptions())
{
throw blException;
}
try
{
DesignationInterface dsDesignation;
dsDesignation=codeWiseDesignationsMap.get(code);
new DesignationDAO().delete(code);
// remove the old one from all DS
codeWiseDesignationsMap.remove(code);
titleWiseDesignationsMap.remove(dsDesignation.getTitle().toUpperCase());
designationsSet.remove(dsDesignation);
}catch(DAOException daoException)
{
blException.setGenericException(daoException.getMessage());
throw blException;
}
}
public DesignationInterface getDesignationByCode(int code) throws BLException
{
DesignationInterface designation=new Designation();
DesignationInterface dsDesignation=codeWiseDesignationsMap.get(code);
if(dsDesignation==null)
{
BLException blException=new BLException();
blException.addException("code","Invalid code : "+code);
throw blException;
}
designation.setCode(dsDesignation.getCode());
designation.setTitle(dsDesignation.getTitle());
return designation;
}
DesignationInterface getDSDesignationByCode(int code)
{
DesignationInterface dsDesignation=codeWiseDesignationsMap.get(code);
return dsDesignation;
}
public DesignationInterface getDesignationByTitle(String title) throws BLException
{
DesignationInterface designation=new Designation();
DesignationInterface dsDesignation=titleWiseDesignationsMap.get(title.toUpperCase());
if(dsDesignation==null)
{
BLException blException=new BLException();
blException.addException("title","Invalid title : "+title);
throw blException;
}
designation.setCode(dsDesignation.getCode());
designation.setTitle(dsDesignation.getTitle());
return designation;
}
public int getDesignationCount()
{
return designationsSet.size();
}
public boolean designationCodeExists(int code)
{
return codeWiseDesignationsMap.containsKey(code);
}
public boolean designationTitleExists(String title)
{
return titleWiseDesignationsMap.containsKey(title.toUpperCase());
}
public Set<DesignationInterface> getDesignations()
{
Set<DesignationInterface> designations=new TreeSet<>();
designationsSet.forEach((designation)->{
DesignationInterface d=new Designation();
d.setCode(designation.getCode());
d.setTitle(designation.getTitle());
designations.add(d);
});
return designations;
}
}