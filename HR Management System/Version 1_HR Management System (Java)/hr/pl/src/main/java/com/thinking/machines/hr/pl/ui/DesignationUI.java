package com.thinking.machines.hr.pl.ui;
import com.thinking.machines.hr.pl.model.*;
import com.thinking.machines.hr.bl.exceptions.*;
import com.thinking.machines.hr.bl.interfaces.pojo.*;
import com.thinking.machines.hr.bl.pojo.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import javax.swing.filechooser.*;
import java.io.*;
public class DesignationUI extends JFrame implements DocumentListener, ListSelectionListener
{
private JLabel titleLabel;
private JLabel searchLabel;
private JTextField searchTextField;
private JButton clearSearchFieldButton;
private JLabel searchErrorLabel;
private DesignationModel designationModel;
private JTable designationTable;
private JScrollPane scrollPane;
private DesignationPanel designationPanel;
private Container container;
private enum MODE{VIEW,ADD,EDIT,DELETE,EXPORT_TO_PDF};
private MODE mode;

private ImageIcon logoIcon;
private ImageIcon addIcon;
private ImageIcon editIcon;
private ImageIcon deleteIcon;
private ImageIcon pdfIcon;
private ImageIcon clearIcon;
private ImageIcon cancelIcon;
private ImageIcon saveIcon;
private ImageIcon updateIcon;

public DesignationUI()
{
initComponents();
setAppearance();
setListeners();
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setViewMode();
designationPanel.setViewMode();
}
private void initComponents()
{
logoIcon=new ImageIcon(getClass().getResource("/icons/logo.png"));
addIcon=new ImageIcon(getClass().getResource("/icons/add.png"));
editIcon=new ImageIcon(getClass().getResource("/icons/edit.png"));
cancelIcon=new ImageIcon(getClass().getResource("/icons/cancel.png"));
deleteIcon=new ImageIcon(getClass().getResource("/icons/delete.png"));
pdfIcon=new ImageIcon(getClass().getResource("/icons/pdf.png"));
clearIcon=new ImageIcon(getClass().getResource("/icons/clear.png"));
saveIcon=new ImageIcon(getClass().getResource("/icons/save.png"));
updateIcon=new ImageIcon(getClass().getResource("/icons/update.png"));
designationModel=new DesignationModel();
designationTable=new JTable(designationModel);
scrollPane=new JScrollPane(designationTable,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);

setIconImage(logoIcon.getImage());
titleLabel=new JLabel("Designation");
searchLabel=new JLabel("Search");
searchTextField=new JTextField();
clearSearchFieldButton=new JButton(clearIcon);
clearSearchFieldButton.setContentAreaFilled(false);
clearSearchFieldButton.setBorderPainted(false);
searchErrorLabel=new JLabel("");
designationPanel=new DesignationPanel();
container=getContentPane();
}
private void setAppearance()
{
Font titleFont=new Font("Roboto",Font.BOLD,22);
Font searchFont=new Font("Roboto",Font.BOLD,20);
Font columnHeaderFont=new Font("Roboto",Font.BOLD,16);
Font dataFont=new Font("Roboto",Font.PLAIN,16);
Font searchErrorFont=new Font("Roboto",Font.BOLD,12);

titleLabel.setFont(titleFont);
searchLabel.setFont(searchFont);
designationTable.setFont(dataFont);
searchErrorLabel.setFont(searchErrorFont);
searchErrorLabel.setForeground(Color.red);

designationTable.setRowHeight(35);
designationTable.getColumnModel().getColumn(0).setPreferredWidth(30);
designationTable.getColumnModel().getColumn(1).setPreferredWidth(400);
JTableHeader header=designationTable.getTableHeader();
header.setFont(columnHeaderFont);
designationTable.setRowSelectionAllowed(true);
designationTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
header.setReorderingAllowed(false);
header.setResizingAllowed(false);

container.setLayout(null);

int lm=0;
int tm=0;
titleLabel.setBounds(lm+20,tm+10,200,40);
searchErrorLabel.setBounds(lm+20+200+200+20+10+5,tm+40,100,20);
searchLabel.setBounds(lm+20,tm+10+20+20+10,100,30);
searchTextField.setBounds(lm+100,tm+10+20+20+10,420,30);
clearSearchFieldButton.setBounds(lm+420+100+10,tm+10+40+10,32,32);
scrollPane.setBounds(lm+20,tm+10+40+40+20,550,300);
designationPanel.setBounds(lm+20,tm+10+40+40+20+300+20,550,150);



container.add(titleLabel);
container.add(searchErrorLabel);
container.add(searchLabel);
container.add(searchTextField);
container.add(clearSearchFieldButton);
container.add(scrollPane);
container.add(designationPanel);

Dimension d=Toolkit.getDefaultToolkit().getScreenSize();

int w=600;
int h=650;
setSize(w,h);
setLocation((d.width/2)-(w/2),(d.height/2)-(h/2));

}
private void setListeners()
{
searchTextField.getDocument().addDocumentListener(this);
clearSearchFieldButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
searchTextField.setText("");
searchTextField.requestFocus();
}
});
designationTable.getSelectionModel().addListSelectionListener(this);
}
public void searchDesignation()
{
searchErrorLabel.setText("");
String title=searchTextField.getText().trim();
if(title.length()==0) return;
int rowIndex;
try
{
rowIndex=designationModel.indexOfTitle(title,true);
} catch(BLException blException)
{
searchErrorLabel.setText("Not Found");
return;
}
designationTable.setRowSelectionInterval(rowIndex,rowIndex);
Rectangle rectangle=designationTable.getCellRect(rowIndex,0,true);
designationTable.scrollRectToVisible(rectangle);
}
public void insertUpdate(DocumentEvent de)
{
searchDesignation();
}
public void removeUpdate(DocumentEvent de)
{
searchDesignation(); 
}
public void changedUpdate(DocumentEvent de)
{
searchDesignation();
}
public void valueChanged(ListSelectionEvent lse)
{
int selectedRowIndex=designationTable.getSelectedRow();
try
{
DesignationInterface designation=designationModel.getDesignationAt(selectedRowIndex);
designationPanel.setDesignation(designation);
}catch(BLException blException)
{
designationPanel.clearDesignation();
}
}

private void setViewMode()
{
this.mode=MODE.VIEW;
if(designationModel.getRowCount()==0)
{
searchTextField.setEnabled(false);
clearSearchFieldButton.setEnabled(false);
designationTable.setEnabled(false);
}
else
{
searchTextField.setEnabled(true);
clearSearchFieldButton.setEnabled(true);
designationTable.setEnabled(true);
}
}

private void setAddMode()
{
this.mode=MODE.ADD;
searchTextField.setEnabled(false);
clearSearchFieldButton.setEnabled(false);
designationTable.setEnabled(false);
}

private void setEditMode()
{
this.mode=MODE.EDIT;
searchTextField.setEnabled(false);
clearSearchFieldButton.setEnabled(false);
designationTable.setEnabled(false);
}

private void setDeleteMode()
{
this.mode=MODE.DELETE;
searchTextField.setEnabled(false);
clearSearchFieldButton.setEnabled(false);
designationTable.setEnabled(false);
}

private void setExportToPDFMode()
{
this.mode=MODE.EXPORT_TO_PDF;
searchTextField.setEnabled(false);
clearSearchFieldButton.setEnabled(false);
designationTable.setEnabled(false);
}

//inner class
class DesignationPanel extends JPanel
{

private JLabel titleCaptionLabel;
private JLabel titleLabel;
private JTextField titleTextField;
private JButton clearTitleTextFieldButton;
private JButton addButton;
private JButton editButton;
private JButton cancelButton;
private JButton deleteButton;
private JButton exportToPDFButton;
private JPanel buttonsPanel;
private DesignationInterface designation;

DesignationPanel()
{
setBorder(BorderFactory.createLineBorder(new Color(150,150,150)));
initComponents();
setAppearance();
setListeners();
}
public void setDesignation(DesignationInterface designation)
{
this.designation=designation;
titleLabel.setText(designation.getTitle());
}
public void clearDesignation()
{
this.designation=null;
titleLabel.setText("");
}
private void initComponents()
{
designation=null;
titleCaptionLabel=new JLabel("Designation");
titleLabel=new JLabel("");
titleTextField=new JTextField();
clearTitleTextFieldButton=new JButton(clearIcon);
clearTitleTextFieldButton.setContentAreaFilled(false);
clearTitleTextFieldButton.setBorderPainted(false);
addButton=new JButton(addIcon);
addButton.setContentAreaFilled(false);
addButton.setBorderPainted(false);
editButton=new JButton(editIcon);
editButton.setContentAreaFilled(false);
editButton.setBorderPainted(false);
cancelButton=new JButton(cancelIcon);
cancelButton.setContentAreaFilled(false);
cancelButton.setBorderPainted(false);
deleteButton=new JButton(deleteIcon);
deleteButton.setContentAreaFilled(false);
deleteButton.setBorderPainted(false);
exportToPDFButton=new JButton(pdfIcon);
exportToPDFButton.setContentAreaFilled(false);
exportToPDFButton.setBorderPainted(false);
buttonsPanel=new JPanel();
}
private void setAppearance()
{
Font titleCaptionFont=new Font("Roboto",Font.BOLD,20);
Font titleFont=new Font("Roboto",Font.PLAIN,18);

titleCaptionLabel.setFont(titleCaptionFont);
titleTextField.setFont(titleFont);
titleLabel.setFont(titleFont);

setLayout(null);
int lm=0;
int tm=0;
titleCaptionLabel.setBounds(lm+30,tm+20,150,40);
titleLabel.setBounds(lm+30+100+30,tm+20,200,40);
titleTextField.setBounds(lm+30+100+30,tm+20,320,30);
clearTitleTextFieldButton.setBounds(lm+50+200+200+20+10+10,tm+20,32,32);

buttonsPanel.setBorder(BorderFactory.createLineBorder(new Color(0,0,0)));
buttonsPanel.setLayout(null);
addButton.setBounds(40,10,32,32);
editButton.setBounds(40+50+30,10,32,32);
cancelButton.setBounds(40+50+30+50+30,10,32,32);
deleteButton.setBounds(40+50+30+50+30+50+30,10,32,32);
exportToPDFButton.setBounds(40+50+30+50+30+50+30+50+30,10,32,32);
buttonsPanel.add(addButton);
buttonsPanel.add(editButton);
buttonsPanel.add(cancelButton);
buttonsPanel.add(deleteButton);
buttonsPanel.add(exportToPDFButton);

buttonsPanel.setBounds(lm+50,tm+20+50,450,50);

add(titleCaptionLabel);
add(titleLabel);
add(titleTextField);
add(clearTitleTextFieldButton);
add(buttonsPanel);
}
private boolean addDesignation()
{
String title=titleTextField.getText().trim();
if(title.length()==0)
{
JOptionPane.showMessageDialog(this,"Designation Required");
titleTextField.requestFocus();
return false;
}
DesignationInterface d=new Designation();
d.setTitle(title);
try
{
designationModel.add(d);
int rowIndex=0;
try
{
rowIndex=designationModel.indexOfDesignation(d);
} catch(BLException blException)
{
// do nothing
}
designationTable.setRowSelectionInterval(rowIndex,rowIndex);
Rectangle rectangle=designationTable.getCellRect(rowIndex,0,true);
designationTable.scrollRectToVisible(rectangle);
return true;
}catch(BLException blException)
{
if(blException.hasGenericException())
{
JOptionPane.showMessageDialog(this,blException.getGenericException());
}
else
{
if(blException.hasException("title"))
{
JOptionPane.showMessageDialog(this,blException.getException("title"));
}
}
titleTextField.requestFocus();
return false;
}
}
private boolean updateDesignation()
{
String title=titleTextField.getText().trim();
if(title.length()==0)
{
JOptionPane.showMessageDialog(this,"Designation Required");
titleTextField.requestFocus();
return false;
}
DesignationInterface d=new Designation();
d.setCode(this.designation.getCode());
d.setTitle(title);
try
{
designationModel.update(d);
int rowIndex=0;
try
{
rowIndex=designationModel.indexOfDesignation(d);
} catch(BLException blException)
{
// do nothing
}
designationTable.setRowSelectionInterval(rowIndex,rowIndex);
Rectangle rectangle=designationTable.getCellRect(rowIndex,0,true);
designationTable.scrollRectToVisible(rectangle);
return true;
}catch(BLException blException)
{
if(blException.hasGenericException())
{
JOptionPane.showMessageDialog(this,blException.getGenericException());
}
else
{
if(blException.hasException("title"))
{
JOptionPane.showMessageDialog(this,blException.getException("title"));
}
}
titleTextField.requestFocus();
return false;
}
}
private void removeDesignation()
{
try
{
String title=this.designation.getTitle().trim();
int selectedOption=JOptionPane.showConfirmDialog(this,"Delete "+title+" ?","Confirmation",JOptionPane.YES_NO_OPTION);
if(selectedOption==JOptionPane.NO_OPTION) return;
designationModel.remove(this.designation.getCode());
JOptionPane.showMessageDialog(this,title+" deleted");
}catch(BLException blException)
{
if(blException.hasGenericException())
{
JOptionPane.showMessageDialog(this,blException.getGenericException());
}
else
{
if(blException.hasException("title"))
{
JOptionPane.showMessageDialog(this,blException.getException("title"));
}
}
}
}
private void setListeners()
{
this.addButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(mode==MODE.VIEW)
{
setAddMode();
}
else
{
if(addDesignation())
{
setViewMode();
}
}
}
});
this.editButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
if(mode==MODE.VIEW)
{
setEditMode();
}
else
{
if(updateDesignation())
{
setViewMode();
}
}
}
});
this.cancelButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
setViewMode();
}
});
this.deleteButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
setDeleteMode();
}
});


this.exportToPDFButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
JFileChooser jfc=new JFileChooser();
jfc.setCurrentDirectory(new File("."));
jfc.setAcceptAllFileFilterUsed(false);
jfc.addChoosableFileFilter(new javax.swing.filechooser.FileFilter(){
public boolean accept(File file)
{
if(file.isDirectory()) return true;
if(file.getName().endsWith(".pdf")) return true;
return false;
}
public String getDescription()
{
return "PDF Files";
}
});
int selectedOption=jfc.showSaveDialog(DesignationUI.this);
if(selectedOption==jfc.APPROVE_OPTION)
{
try
{
File selectedFile=jfc.getSelectedFile();
String pdfFile=selectedFile.getAbsolutePath();
if(pdfFile.endsWith(".")) pdfFile+="pdf";
else if(pdfFile.endsWith(".pdf")==false) pdfFile+=".pdf";
File file=new File(pdfFile);
File parent=new File(file.getParent());
if(parent.exists()==false || parent.isDirectory()==false)
{
JOptionPane.showMessageDialog(DesignationUI.this,"Incorrect path : "+file.getAbsolutePath());
return;
}
System.out.println(file);
designationModel.exportToPDF(file);
JOptionPane.showMessageDialog(DesignationUI.this,"Data exported to : "+file.getAbsolutePath());
}catch(BLException blException)
{
if(blException.hasGenericException())
{
JOptionPane.showMessageDialog(DesignationUI.this,blException.getGenericException());
}
}
catch(Exception e)
{

}
}
}
});



this.clearTitleTextFieldButton.addActionListener(new ActionListener(){
public void actionPerformed(ActionEvent ae)
{
titleTextField.setText("");
titleTextField.requestFocus();
}
});
}
void setViewMode()
{
DesignationUI.this.setViewMode();
this.titleTextField.setVisible(false);
this.clearTitleTextFieldButton.setVisible(false);
this.titleLabel.setVisible(true);
this.addButton.setIcon(addIcon);
this.editButton.setIcon(editIcon);
this.addButton.setEnabled(true);
this.cancelButton.setEnabled(false);
if(designationModel.getRowCount()>0)
{
this.editButton.setEnabled(true);
this.deleteButton.setEnabled(true);
this.exportToPDFButton.setEnabled(true);
}
else
{
this.editButton.setEnabled(false);
this.deleteButton.setEnabled(false);
this.exportToPDFButton.setEnabled(false);
}
}
void setAddMode()
{
DesignationUI.this.setAddMode();
this.titleTextField.setText("");
this.clearTitleTextFieldButton.setVisible(true);
this.titleLabel.setVisible(false);
this.titleTextField.setVisible(true);
this.addButton.setIcon(saveIcon);
this.cancelButton.setEnabled(true);
this.editButton.setEnabled(false);
this.deleteButton.setEnabled(false);
this.exportToPDFButton.setEnabled(false);
}
void setEditMode()
{
if(this.designation==null)
{
JOptionPane.showMessageDialog(this,"Select Designation to edit");
return;
}
DesignationUI.this.setEditMode();
this.titleTextField.setText(this.designation.getTitle());
this.clearTitleTextFieldButton.setVisible(true);
this.titleLabel.setVisible(false);
this.titleTextField.setVisible(true);
this.addButton.setEnabled(false);
this.cancelButton.setEnabled(true);
this.editButton.setIcon(updateIcon);
this.deleteButton.setEnabled(false);
this.exportToPDFButton.setEnabled(false);
}
void setDeleteMode()
{
if(this.designation==null)
{
JOptionPane.showMessageDialog(this,"Select Designation to delete");
return;
}
DesignationUI.this.setDeleteMode();
this.titleLabel.setVisible(false);
this.titleTextField.setVisible(false);
this.addButton.setEnabled(false);
this.cancelButton.setEnabled(false);
this.editButton.setEnabled(false);
this.deleteButton.setEnabled(false);
this.exportToPDFButton.setEnabled(false);
removeDesignation();
setViewMode();
DesignationUI.this.setViewMode();
}
void setExportToPDFMode()
{
DesignationUI.this.setExportToPDFMode();
this.titleLabel.setVisible(false);
this.titleTextField.setVisible(false);
this.addButton.setEnabled(false);
this.cancelButton.setEnabled(false);
this.editButton.setEnabled(false);
this.deleteButton.setEnabled(false);
this.exportToPDFButton.setEnabled(false);
}
}//inner class ends here
}